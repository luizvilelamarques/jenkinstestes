def server
def registry
def secret
def app
def image
def isLatest
def branch

def build(){
    docker.withServer(server, '') {
	app = docker.build(_imagemDocker())
    }
}

def push(){
    docker.withServer(server,'') {
	docker.withRegistry(registry, secret) {
	    app.push()
	}
     }
}

def _imagemDocker(){
    if (isLatest){
	return "registry.intra.tjmg.gov.br/${image}:latest"
    }
    return "registry.intra.tjmg.gov.br/${image}:${branch}"
} 
	
def instancia(dockerInfo, img, latest, branch){
   image = img
   isLatest = latest
   branch = branch
   server   = "tcp://lindocker-2.intra.tjmg.gov.br:2375"
   registry = "https://registry.intra.tjmg.gov.br"
   secret   = "codap-registry"
   return this			
}

return this
