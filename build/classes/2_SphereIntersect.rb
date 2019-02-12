				scene = Scene.new "SphereIntersect"
				
				#create Camera
        camera = Camera.new
				camera.setStartVector(Vector3D.new(0.0,0.0,0.0))
        camera.setDirectionVector(Vector3D.new(0.0,0.0,1000.0))
       
        #create Light
        light = PointLight.new("l1")
        light.setLocation(Vector3D.new(0.0,0.0,0.0))
        light.setColour(RGBColour.new(1.0,1.0,1.0))
        light.setDiffuseIntensity(RGBColour.new(0.7,0.7,0.7))
        light.setSpecularIntensity(RGBColour.new(0.7,0.7,0.7))
        
        #create material
        material = Material.new
        material.setDiffuse(RGBColour.new(0.7,0.7,0.7))
        material.setSpecular(RGBColour.new(0.7,0.7,0.7))
        material.setSpecularFactor(100.0)
        
        #create Spheres
        sphere = Sphere.new("s1")
        sphere.setRadius(100.0)
        sphere.setColour(RGBColour.new(1.0,1.0,1.0))
        sphere.setLocation(Vector3D.new(0.0,100.0,200.0))
        sphere.setMaterial(material)
				
				sphere2 = Sphere.new("s2")
        sphere2.setRadius(100.0)
        sphere2.setColour(RGBColour.new(1.0,0.0,0.0))
        sphere2.setLocation(Vector3D.new(0.0,-200.0,1200.0))
        sphere2.setMaterial(material)
				
				sphere3 = Sphere.new("s3")
        sphere3.setRadius(100.0)
        sphere3.setColour(RGBColour.new(0.0,1.0,0.0))
        sphere3.setLocation(Vector3D.new(-300.0,0.0,600.0))
        sphere3.setMaterial(material)
				
				sphere4 = Sphere.new("s4")
        sphere4.setRadius(100.0)
        sphere4.setColour(RGBColour.new(0.0,0.0,1.0))
        sphere4.setLocation(Vector3D.new(300.0,0.0,600.0))
        sphere4.setMaterial(material)
         
        #add objects to scene
        scene.setCamera(camera)
        scene.add(light)
        scene.add(sphere)
				scene.add(sphere2)
				scene.add(sphere3)
				scene.add(sphere4)
     	
				#make sure scene is last term
				scene
				
				