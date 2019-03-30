require 'java'

include_class 'java.awt.Color'

include_class 'javaraytracer.Matrix'
include_class 'javaraytracer.Vector3D'
include_class 'javaraytracer.PointLight'
include_class 'javaraytracer.Sphere'
include_class 'javaraytracer.Plane'
include_class 'javaraytracer.Triangle'
include_class 'javaraytracer.Material'
include_class 'javaraytracer.Scene'
include_class 'javaraytracer.RayTracer'

module JavaRayTracer

include_package 'javaraytracer'

attr  :scene
attr  :rayTracer
attr  :image

def JavaRayTracer.rayTracer
	if @rayTracer.nil?
		@rayTracer = RayTracer.new
	end
	@rayTracer
end
				
def JavaRayTracer.scene
	if @scene.nil?
		@scene = Scene.new
	end
	@scene
end

def JavaRayTracer.render
	@image = @rayTracer.render(@scene)
	@rayTracer.display(@image)
end

def JavaRayTracer.save (fileName="test")
	@rayTracer.save(@image,fileName)
	end
	
def JavaRayTracer.renderScene(sceneName,superSampling=1,height=640,width=480)

		if @rayTracer == nil
			@rayTracer = RayTracer.new(height,width)
		end
						
		@rayTracer.setSuperSampling(superSampling)
					
		aFile = File.new(sceneName + ".rb", "r")
		s = ""
			aFile.each_line do |line|
				s.concat(line)
			end
		aFile.close
		@scene = eval(s)
		
		@image = @rayTracer.render(@scene)
		@rayTracer.display(@image)
		@rayTracer.save(@image,sceneName)
		
end
					
end