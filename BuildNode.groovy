def pacote

def instancia(buildInfo){
     pacote = buildInfo.package
     return this
}

def build(){
    sh " npm run build -f ${pacote}"
}

return this
