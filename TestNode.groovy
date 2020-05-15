def pacote

def instancia(buildInfo){
     pacote = buildInfo.package
     return this
}

def test(){
    sh " echo teste nodejs"
}

return this
