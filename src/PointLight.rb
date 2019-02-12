				scene = Scene.new "PointLight"
				
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
				light.setRange(600)
				
				light2 = PointLight.new("l2")
        light2.setLocation(Vector3D.new(0.0,-200.0,1200.0))
        light2.setColour(RGBColour.new(1.0,1.0,1.0))
        light2.setDiffuseIntensity(RGBColour.new(0.7,0.7,0.7))
        light2.setSpecularIntensity(RGBColour.new(0.7,0.7,0.7))
				light2.setRange(600)
        
        #create material
        material = Material.new
        material.setDiffuse(RGBColour.new(0.7,0.7,0.7))
        material.setSpecular(RGBColour.new(0.7,0.7,0.7))
        material.setSpecularFactor(100.0)
				
				 #create Spheres
        sphere = Sphere.new("s1")
        sphere.setRadius(70.0)
        sphere.setColour(RGBColour.new(1.0,1.0,1.0))
        sphere.setLocation(Vector3D.new(200.0,120.0,300.0))
        sphere.setMaterial(material)
				
				sphere2 = Sphere.new("s2")
        sphere2.setRadius(70.0)
        sphere2.setColour(RGBColour.new(1.0,0.0,0.0))
        sphere2.setLocation(Vector3D.new(-200.0,120.0,300.0))
        sphere2.setMaterial(material)
				
				sphere3 = Sphere.new("s3")
        sphere3.setRadius(70.0)
        sphere3.setColour(RGBColour.new(0.0,1.0,0.0))
        sphere3.setLocation(Vector3D.new(200.0,0.0,900.0))
        sphere3.setMaterial(material)
				
				sphere4 = Sphere.new("s4")
        sphere4.setRadius(70.0)
        sphere4.setColour(RGBColour.new(0.0,0.0,1.0))
        sphere4.setLocation(Vector3D.new(-200.0,0.0,900.0))
        sphere4.setMaterial(material)
        
        #create planes
        plane = Plane.new("p1")
        plane.setColour(RGBColour.new(1.0,1.0,1.0))
        plane.setLocation(Vector3D.new(0.0,240.0,0.0))
				plane.setNormal(Vector3D.new(0.0,-1.0,0.0))
        plane.setMaterial(material)
				
				plane2 = Plane.new("p2")
        plane2.setColour(RGBColour.new(1.0,0.0,0.0))
        plane2.setLocation(Vector3D.new(0.0,-240.0,0.0))
				plane2.setNormal(Vector3D.new(0.0,1.0,0.0))
        plane2.setMaterial(material)
				
				plane3 = Plane.new("p3")
        plane3.setColour(RGBColour.new(0.0,1.0,0.0))
        plane3.setLocation(Vector3D.new(-320.0,0.0,0.0))
				plane3.setNormal(Vector3D.new(1.0,0.0,0.0))
        plane3.setMaterial(material)
				
				plane4 = Plane.new("p4")
        plane4.setColour(RGBColour.new(0.0,1.0,1.0))
        plane4.setLocation(Vector3D.new(320.0,0.0,0.0))
				plane4.setNormal(Vector3D.new(-1.0,0.0,0.0))
        plane4.setMaterial(material)
				
				plane5 = Plane.new("p5")
        plane5.setColour(RGBColour.new(0.0,0.0,1.0))
        plane5.setLocation(Vector3D.new(0.0,0.0,2000.0))
				plane5.setNormal(Vector3D.new(0.0,0.0,-1.0))
        plane5.setMaterial(material)
         
        #add objects to scene
        scene.setCamera(camera)
        scene.add(light)
				scene.add(light2)
				scene.add(plane)
				scene.add(plane2)
				scene.add(plane3)
				scene.add(plane4)
				scene.add(plane5)
				scene.add(sphere)
				scene.add(sphere2)
				scene.add(sphere3)
				scene.add(sphere4)
				
				#make sure scene is last term
				scene
				
				