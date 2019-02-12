				scene = Scene.new "SphereIntersect"
				
				#create Camera
        camera = Camera.new
				camera.setStartVector(Vector3D.new(0.0,0.0,0.0))
        camera.setDirectionVector(Vector3D.new(0.0,0.0,1000.0))
       
        #create Light
        light = PointLight.new("l1")
        light.setLocation(Vector3D.new(200.0,-100.0,0.0))
        light.setColour(RGBColour.new(1.0,1.0,1.0))
        light.setDiffuseIntensity(RGBColour.new(0.7,0.7,0.7))
        light.setSpecularIntensity(RGBColour.new(0.7,0.7,0.7))
				
				light2 = PointLight.new("l2")
        light2.setLocation(Vector3D.new(-200.0,0.0,0.0))
        light2.setColour(RGBColour.new(1.0,1.0,1.0))
        light2.setDiffuseIntensity(RGBColour.new(0.7,0.7,0.7))
        light2.setSpecularIntensity(RGBColour.new(0.7,0.7,0.7))
        
        #create material
        material = Material.new
        material.setDiffuse(RGBColour.new(0.7,0.7,0.7))
        material.setSpecular(RGBColour.new(0.7,0.7,0.7))
        material.setSpecularFactor(100.0)
        
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
				
				cube = Mesh.new("m1")
				cube.setTriangles(triangles)
				cube.setColour(RGBColour.new(1.0,0.0,0.0))
				cube.setMaterial(material)
				rm = Matrix::multiply(Matrix::createRotationMatrix(triangle.getV1(),35.0,Matrix::Y_AXIS),Matrix::createRotationMatrix(triangle.getV1(),45.0,Matrix::X_AXIS))
				sm = Matrix::multiply(rm,Matrix::createScalingMatrix(triangle.getV1(),1.1,1.1,1.1))
				cube.setMatrix(sm)
				cube.transform
		
				
				cube2 = Mesh.new("m2",cube)
				cube2.setMatrix(Matrix.createTranslationMatrix(-200,100,0))
				cube2.transform
				
				cube3 = Mesh.new("m3",cube)
				cube3.setMatrix(Matrix::multiply(Matrix.createTranslationMatrix(200,100,0),Matrix::createScalingMatrix(cube3.getTriangles[0].getV1(),0.5,0.5,0.5)))
				cube3.transform
				
				cube4 = Mesh.new("m4",cube)
				cube4.setMatrix(Matrix::multiply(Matrix::createRotationMatrix(cube4.getTriangles[0].getV1(),-70.0,Matrix::Y_AXIS),Matrix::multiply(Matrix.createTranslationMatrix(0,200,0),Matrix::createScalingMatrix(cube4.getTriangles[0].getV1(),2.0,2.0,2.0))))
				cube4.transform
					
         
        #add objects to scene
        scene.setCamera(camera)
        scene.add(light)
				scene.add(light2)
        scene.add(cube)
				scene.add(cube2)
				scene.add(cube3)
				scene.add(cube4)
     	
				#make sure scene is last term
				scene
				
				