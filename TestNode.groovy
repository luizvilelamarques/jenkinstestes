def pacote

def instancia(buildInfo){
     pacote = buildInfo.package
     return this
}

def build(){
    sh " echo teste nodejs"
}

return this
