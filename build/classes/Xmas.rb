				scene = Scene.new "Xmas"
				
				#create Camera
        camera = Camera.new
				camera.setStartVector(Vector3D.new(0.0,0.0,0.0))
        camera.setDirectionVector(Vector3D.new(0.0,0.0,1000.0))
		
        #create Light
        light = PointLight.new("l1")
        light.setLocation(Vector3D.new(0.0,0.0,100.0))
        light.setColour(RGBColour.new(1.0,1.0,1.0))
        light.setDiffuseIntensity(RGBColour.new(0.7,0.7,0.7))
        light.setSpecularIntensity(RGBColour.new(0.7,0.7,0.7))
				light.setRange(500)
	      
        #create Yard
				yardM = Material.new
        yardM.setDiffuse(RGBColour.new(0.7,0.7,0.7))
				
				yard = Plane.new("yard")
        yard.setColour(RGBColour.new(0.0,1.0,0.0))
        yard.setLocation(Vector3D.new(0.0,350.0,0.0))
				yard.setNormal(Vector3D.new(0.0,-1.0,0.0))
        yard.setMaterial(yardM)
				
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
				
				houseM = Material.new
        houseM.setDiffuse(RGBColour.new(0.7,0.7,0.7))
				
				cube = Mesh.new("cube")
				cube.setTriangles(triangles)
						
				#create house
				house = Mesh.new("house",cube)
				house.setColour(RGBColour.new(1.0,1.0,1.0))
				house.setMaterial(houseM)
				house.setMatrix(Matrix::multiply(Matrix::createRotationMatrix(house.getTriangles[0].getV1(),35.0,Matrix::Y_AXIS),Matrix::createTranslationMatrix(-600,250,800)))
				house.setMatrix(Matrix::multiply(house.getMatrix,Matrix::createScalingMatrix(house.getTriangles[0].getV1(),4.0,2.0,2.0)))
				house.transform
				
				#create pool
				poolM = Material.new
        poolM.setDiffuse(RGBColour.new(0.7,0.7,0.7))
				poolM.setSpecular(RGBColour.new(0.7,0.7,0.7))
        poolM.setSpecularFactor(200.0)
				
				pool = Mesh.new("pool",cube)
				pool.setColour(RGBColour.new(0.0,0.0,1.0))
				pool.setMaterial(poolM)
				pM = Matrix.multiply(Matrix::createTranslationMatrix(-400,448,0),Matrix::createScalingMatrix(pool.getTriangles[0].getV1(),1.0,1.0,3.0))
				pool.setMatrix(pM)
				pool.setReflect(1.0)
				pool.transform
				
				#create roof
				rt1 = Triangle.new("rt1")
				rt1.setV1(Vector3D.new(0,-100,300))
				rt1.setV2(Vector3D.new(-100,0,200))
				rt1.setV3(Vector3D.new(100,0,200))
				
				rt2 = Triangle.new("rt2")
				rt2.setV1(Vector3D.new(0,-100,300))
				rt2.setV2(Vector3D.new(100,0,200))
				rt2.setV3(Vector3D.new(100,0,400))
				
				rt3 = Triangle.new("rt3")
				rt3.setV1(Vector3D.new(0,-100,300))
				rt3.setV2(Vector3D.new(-100,0,400))
				rt3.setV3(Vector3D.new(-100,0,200))
				
				rt4 = Triangle.new("rt4")
				rt4.setV1(Vector3D.new(0,-100,300))
				rt4.setV2(Vector3D.new(100,0,400))
				rt4.setV3(Vector3D.new(-100,0,400))
		
				
				rts = Triangle[].new(4)
				rts[0] = rt1
				rts[1] = rt2
				rts[2] = rt3
				rts[3] = rt4
				
				roofM = Material.new
        roofM.setDiffuse(RGBColour.new(0.7,0.7,0.7))
				roofM.setSpecular(RGBColour.new(0.7,0.7,0.7))
        roofM.setSpecularFactor(100.0)
				
				roof = Mesh.new("roof")
				roof.setTriangles(rts)
				roof.setColour(RGBColour.new(1.0,0,0))
				roof.setMaterial(roofM)
				
				rM = Matrix::createRotationMatrix(roof.getTriangles[0].getV1(),35.0,Matrix::Y_AXIS)
				rM  = Matrix::multiply(rM,Matrix::createScalingMatrix(1.5,1,1))
				rM = Matrix::multiply(rM,Matrix::createTranslationMatrix(10,100,80))
				roof.setMatrix(rM)
				roof.transform				
				
				#create tree and decoration
				tt1 = Triangle.new("tt1")
				tt1.setV1(Vector3D.new(200,-200,300))
				tt1.setV2(Vector3D.new(0,0,300))
				tt1.setV3(Vector3D.new(400,0,300))
				
				tt2 = Triangle.new("tt2")
				tt2.setV1(Vector3D.new(200,-270,300))
				tt2.setV2(Vector3D.new(50,-120,300))
				tt2.setV3(Vector3D.new(350,-120,300))
				
				tt3 = Triangle.new("tt3")
				tt3.setV1(Vector3D.new(200,-320,300))
				tt3.setV2(Vector3D.new(100,-220,300))
				tt3.setV3(Vector3D.new(300,-220,300))
				
				tts = Triangle[].new(3)
				tts[0] = tt1
				tts[1] = tt2
				tts[2] = tt3
							
				treeM = Material.new
        treeM.setDiffuse(RGBColour.new(0.7,0.7,0.7))
								
				tree = Mesh.new("tree")
				tree.setTriangles(tts)
				tree.setColour(RGBColour.new(0.0,1.0,0.2))
				tree.setMaterial(treeM)
				
				tM = Matrix::createTranslationMatrix(350,300,200)
				tree.setMatrix(tM)
				tree.transform
				
				decoration = Mesh.new("decoration")
				treeTop = tree.getTriangles[2].getV1
				
				dt1 = Triangle.new("dt1")
				dt1.setV1(Vector3D.new(treeTop.getX,treeTop.getY - 50,treeTop.getZ-1))
				dt1.setV2(Vector3D.new(treeTop.getX - 50,treeTop.getY + 20,treeTop.getZ-1))
				dt1.setV3(Vector3D.new(treeTop.getX + 50,treeTop.getY + 20,treeTop.getZ-1))
				
				dt2 = Triangle.new("dt2")
				dt2.setV1(Vector3D.new(treeTop.getX,treeTop.getY + 50,treeTop.getZ-1))
				dt2.setV2(Vector3D.new(treeTop.getX + 50,treeTop.getY - 20,treeTop.getZ-1))
				dt2.setV3(Vector3D.new(treeTop.getX - 50,treeTop.getY - 20,treeTop.getZ-1))
					
				dts = Triangle[].new(2)
				dts[0] = dt1
				dts[1] = dt2
							
				decorationM = Material.new
        decorationM.setDiffuse(RGBColour.new(0.7,0.7,0.7))
								
				decoration = Mesh.new("decoration")
				decoration.setTriangles(dts)
				decoration.setColour(RGBColour.new(1.0,1.0,1.0))
				decoration.setMaterial(decorationM)
				
				decorationLight = PointLight.new("d1")
        decorationLight.setLocation(Vector3D.new(treeTop.getX-2,treeTop.getY-2,treeTop.getZ-2))
        decorationLight.setColour(RGBColour.new(1.0,1.0,1.0))
        decorationLight.setDiffuseIntensity(RGBColour.new(0.7,0.7,0.7))
        decorationLight.setSpecularIntensity(RGBColour.new(0.7,0.7,0.7))
				decorationLight.setRange(300)
								
				
				#create moon
				moonM = Material.new
        moonM.setDiffuse(RGBColour.new(0.7,0.7,0.7))
				moonM.setEmissive(RGBColour.new(0.1,0.1,0.1))
				
				
				moon = Sphere.new("moon")
        moon.setRadius(50.0)
        moon.setColour(RGBColour.new(1.0,1.0,1.0))
        moon.setLocation(Vector3D.new(-500.0,-350.0,300.0))
        moon.setMaterial(moonM)
						
				
				#create stars
				stars = Mesh[].new(50)
				 for i in 0...stars.length
				  
					star = Mesh.new("star".concat(i),decoration)
					r1 = rand
					r2 = rand
					r3 = rand
					if r1 > 0.5 then
						r1 = r1 * -1
					end
					if r2 > 0.5 then
						r2 = r2 * -1
					end
					if r3 > 0.5 then
						r3 = r3 * -1
					end
					
					sM = Matrix::createTranslationMatrix(r1 * 1000,r2 * 1000,1500)
					sM = Matrix::multiply(sM,Matrix::createScalingMatrix(r3 * 0.3,r3 * 0.3, r3 * 0.3))
					star.setMatrix(sM)
					star.transform
					
					starM = Material.new
					starM.setDiffuse(RGBColour.new(0.7,0.7,0.7))
					starM.setEmissive(RGBColour.new(r1 * 1.0, r1 * 1.0,r1 * 1.0))
					star.setMaterial(starM)
						
					stars[i] = star
				
				end

				 
        #add objects to scene
        scene.setCamera(camera)
        scene.add(light)
				scene.add(yard)
				scene.add(house)
				scene.add(roof)
				scene.add(pool)
				scene.add(tree)
				scene.add(decoration)
				scene.add(decorationLight)
				scene.add(moon)
				stars.each { |s| scene.add(s) }
				
				#make sure scene is last term
				scene			