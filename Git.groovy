def credentials
def url
def branch
    
def instancia(gitInfo, branch){
  credentials= gitInfo.credentials
  url= gitInfo.url
  branch= branch
  return this
}

def checkout() {
   git branch: branch, credentialsId: credentials, url: url
}

return this
