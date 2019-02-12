				scene = Scene.new "Texture"
				
				#create Camera
        camera = Camera.new
				camera.setStartVector(Vector3D.new(0.0,0.0,0.0))
        camera.setDirectionVector(Vector3D.new(0.0,0.0,1000.0))
		
        #create Light
        light = PointLight.new("l1")
        light.setLocation(Vector3D.new(0.0,-200.0,200.0))
        light.setColour(RGBColour.new(1.0,1.0,1.0))
        light.setDiffuseIntensity(RGBColour.new(0.7,0.7,0.7))
        light.setSpecularIntensity(RGBColour.new(0.7,0.7,0.7))
							
				light2 = PointLight.new("l2")
        light2.setLocation(Vector3D.new(0.0,-200.0,1200.0))
        light2.setColour(RGBColour.new(1.0,1.0,1.0))
        light2.setDiffuseIntensity(RGBColour.new(0.7,0.7,0.7))
        light2.setSpecularIntensity(RGBColour.new(0.7,0.7,0.7))
			        
        #create materials
        material = Material.new
        material.setDiffuse(RGBColour.new(0.7,0.7,0.7))
        material.setSpecular(RGBColour.new(0.7,0.7,0.7))
        material.setSpecularFactor(100.0)
			  material.setEmissive(RGBColour.new(0.2,0.0,0.0))
				material.setAmbient(RGBColour.new(0.2,0.2,0.2))
				
				material2 = Material.new
        material2.setDiffuse(RGBColour.new(0.7,0.7,0.7))
			
								
				material3 = Material.new
        material3.setDiffuse(RGBColour.new(0.7,0.7,0.7))
        material3.setSpecular(RGBColour.new(0.7,0.7,0.7))
        material3.setSpecularFactor(10.0)
			
				
				material4 = Material.new
        material4.setDiffuse(RGBColour.new(0.7,0.7,0.7))
        material4.setSpecular(RGBColour.new(0.7,0.7,0.7))
        material4.setSpecularFactor(200.0)
				
				material5 = Material.new
        material5.setDiffuse(RGBColour.new(0.1,0.1,0.1))
        material5.setSpecular(RGBColour.new(0.1,0.1,0.1))
        material5.setSpecularFactor(200.0)

      
				
				 #create Spheres
        sphere = Sphere.new("s1")
        sphere.setRadius(70.0)
        sphere.setColour(RGBColour.new(1.0,1.0,1.0))
        sphere.setLocation(Vector3D.new(200.0,120.0,300.0))
        sphere.setMaterial(material)
				sphere.setReflect(0.05)
				
				sphere2 = Sphere.new("s2")
        sphere2.setRadius(70.0)
        sphere2.setColour(RGBColour.new(1.0,0.0,0.0))
        sphere2.setLocation(Vector3D.new(-200.0,120.0,300.0))
        sphere2.setMaterial(material2)
				sphere2.setReflect(1.0)
				
				sphere3 = Sphere.new("s3")
        sphere3.setRadius(70.0)
        sphere3.setColour(RGBColour.new(0.0,1.0,0.0))
        sphere3.setLocation(Vector3D.new(150.0,-100.0,900.0))
        sphere3.setMaterial(material3)
				sphere3.setTexture(RayTracer::createStripePattern(Color::GREEN,Color::YELLOW))
					
				
				sphere4 = Sphere.new("s4")
        sphere4.setRadius(70.0)
        sphere4.setColour(RGBColour.new(0.0,0.0,1.0))
        sphere4.setLocation(Vector3D.new(-100.0,-100.0,900.0))
        sphere4.setMaterial(material3)
				sphere4.setTexture(RayTracer::createCheckPattern(Color::ORANGE,Color::BLUE))
				
				sphere5 = Sphere.new("s5")
        sphere5.setRadius(70.0)
        sphere5.setColour(RGBColour.new(1.0,1.0,1.0))
        sphere5.setLocation(Vector3D.new(0.0,150.0,400.0))
        sphere5.setMaterial(material3)
				sphere5.setRefract(0.7)
        
        #create planes
        plane = Plane.new("p1")
        plane.setColour(RGBColour.new(1.0,1.0,1.0))
        plane.setLocation(Vector3D.new(0.0,240.0,0.0))
				plane.setNormal(Vector3D.new(0.0,-1.0,0.0))
        plane.setMaterial(material4)
				plane.setTexture(RayTracer::createCheckPattern(Color::WHITE,Color::BLACK))
				plane.setReflect(0.5)
				
				plane2 = Plane.new("p2")
        plane2.setColour(RGBColour.new(1.0,0.0,0.0))
        plane2.setLocation(Vector3D.new(0.0,-240.0,0.0))
				plane2.setNormal(Vector3D.new(0.0,1.0,0.0))
        plane2.setMaterial(material2)
				plane2.setTexture(RayTracer::createStripePattern(Color::RED,Color::BLACK))
				
				plane3 = Plane.new("p3")
        plane3.setColour(RGBColour.new(1.0,1.0,0.3))
        plane3.setLocation(Vector3D.new(-320.0,0.0,0.0))
				plane3.setNormal(Vector3D.new(1.0,0.0,0.0))
        plane3.setMaterial(material3)
				plane3.setReflect(1.0)
				
				plane4 = Plane.new("p4")
        plane4.setColour(RGBColour.new(0.0,1.0,1.0))
        plane4.setLocation(Vector3D.new(320.0,0.0,0.0))
				plane4.setNormal(Vector3D.new(-1.0,0.0,0.0))
        plane4.setMaterial(material3)
				plane4.setReflect(1.0)
				
				plane5 = Plane.new("p5")
        plane5.setColour(RGBColour.new(0.0,0.0,1.0))
        plane5.setLocation(Vector3D.new(0.0,0.0,2000.0))
				plane5.setNormal(Vector3D.new(0.0,0.0,-1.0))
        plane5.setMaterial(material4)
				plane5.setTexture(RayTracer::createStripePattern(Color::MAGENTA,Color::CYAN))
				
				 #create Triangles for cube
				#When creating triangles, from whichever point you start from, you must set the next points in an anti-clockwise direction
				 #create front
        triangle = Triangle.new("t1")
        triangle.setV1(Vector3D.new(-100.0,-100.0,200.0))
				triangle.setV2(Vector3D.new(0.0,0.0,200.0))
				triangle.setV3(Vector3D.new(0.0,-100.0,200.0))
				
		  	triangle2 = Triangle.new("t2")
        triangle2.setV1(Vector3D.new(-100.0,-100.0,200.0))
				triangle2.setV2(Vector3D.new(-100.0,0.0,200.0))
				triangle2.setV3(Vector3D.new(0.0,0.0,200.0))
				
				#create top
				triangle3 = Triangle.new("t3")
        triangle3.setV1(Vector3D.new(-100.0,-100.0,300.0))
				triangle3.setV2(Vector3D.new(-100.0,-100.0,200.0))
				triangle3.setV3(Vector3D.new(0.0,-100.0,300.0))
				
				triangle4 = Triangle.new("t4")
        triangle4.setV1(Vector3D.new(0.0,-100.0,300.0))
				triangle4.setV2(Vector3D.new(-100.0,-100.0,200.0))
				triangle4.setV3(Vector3D.new(0.0,-100.0,200.0))
	
			  #create right	
				triangle5 = Triangle.new("t5")
        triangle5.setV1(Vector3D.new(0.0,-100.0,300.0))
				triangle5.setV2(Vector3D.new(0.0,-100.0,200.0))
				triangle5.setV3(Vector3D.new(0.0,0.0,300.0))
				
				triangle6 = Triangle.new("t6")
        triangle6.setV1(Vector3D.new(0.0,0.0,300.0))
				triangle6.setV2(Vector3D.new(0.0,-100.0,200.0))
				triangle6.setV3(Vector3D.new(0.0,0.0,200.0))
				
				 #create left	
				triangle7 = Triangle.new("t7")
        triangle7.setV1(Vector3D.new(-100.0,-100.0,300.0))
		   	triangle7.setV2(Vector3D.new(-100.0,0.0,300.0))
				triangle7.setV3(Vector3D.new(-100.0,-100.0,200.0))
				
				triangle8 = Triangle.new("t8")
        triangle8.setV1(Vector3D.new(-100.0,0.0,300.0))
				triangle8.setV2(Vector3D.new(-100.0,0.0,200.0))
				triangle8.setV3(Vector3D.new(-100.0,-100.0,200.0))
			
				
				 #create back
        triangle9 = Triangle.new("t8")
        triangle9.setV1(Vector3D.new(-100.0,-100.0,300.0))
				triangle9.setV2(Vector3D.new(0.0,-100.0,300.0))
				triangle9.setV3(Vector3D.new(0.0,0.0,300.0))
				
		  	triangle10 = Triangle.new("t10")
        triangle10.setV1(Vector3D.new(-100.0,-100.0,300.0))
		   	triangle10.setV2(Vector3D.new(0.0,0.0,300.0))
				triangle10.setV3(Vector3D.new(-100.0,0.0,300.0))
				
				#create bottom
				triangle11 = Triangle.new("t11")
        triangle11.setV1(Vector3D.new(-100.0,0.0,300.0))
				triangle11.setV2(Vector3D.new(0.0,0.0,300.0))
				triangle11.setV3(Vector3D.new(-100.0,0.0,200.0))
		
				
				triangle12 = Triangle.new("t12")
        triangle12.setV1(Vector3D.new(0.0,0.0,300.0))
				triangle12.setV2(Vector3D.new(0.0,0.0,200.0))
				triangle12.setV3(Vector3D.new(-100.0,0.0,200.0))
			
				
				
				triangles = Triangle[].new(12)
				triangles[0] = triangle
				triangles[1] = triangle2
				triangles[2] = triangle3
				triangles[3] = triangle4
				triangles[4] = triangle5
				triangles[5] = triangle6
				triangles[6] = triangle7
				triangles[7] = triangle8
				triangles[8] = triangle9
				triangles[9] = triangle10
				triangles[10] = triangle11
				triangles[11] = triangle12
				
				cube = Mesh.new("cube")
				cube.setTriangles(triangles)
				cube.setColour(RGBColour.new(1.0,0.0,0.0))
				cube.setMaterial(material)
				rm = Matrix::multiply(Matrix::createRotationMatrix(triangle.getV1(),35.0,Matrix::Y_AXIS),Matrix::createRotationMatrix(triangle.getV1(),35.0,Matrix::X_AXIS))
				cube.setMatrix(Matrix::multiply(rm,Matrix::createTranslationMatrix(-200,250,200)))
				cube.transform
				cube.setTexture(RayTracer::createCheckPattern(Color::WHITE,Color::RED))
         
        #add objects to scene
        scene.setCamera(camera)
        scene.add(light)
				#scene.add(light2)
				scene.add(plane)
				scene.add(plane2)
				scene.add(plane3)
				scene.add(plane4)
				scene.add(plane5)
				scene.add(sphere)
				scene.add(sphere2)
				scene.add(sphere3)
				scene.add(sphere4)
				scene.add(sphere5)
				scene.add(cube)
				
				#make sure scene is last term
				scene
				
				