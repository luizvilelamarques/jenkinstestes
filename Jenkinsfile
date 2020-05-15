/*********************************************************************** 
   ATENÇÃO: Não alterar nada nesta pipeline
   
   Todas as alterações devem ser feitas no 'JenkinsConfig.json'

***********************************************************************/
pipeline{
    parameters {
        gitParameter branchFilter: 'origin/(.*)', 
                     defaultValue: 'develop', 
                     name: 'BRANCH', 
                     type: 'PT_BRANCH_TAG'
    }
    environment {
        pipeline =  null
    }
    agent any
    stages {
        stage('Load scripts') {
            steps{
                script{
                    deleteDir()
                    _groovyBase   = 'https://raw.githubusercontent.com/luizvilelamarques/jenkinstestes/master/'
                    sh "wget ${_groovyBase}/Pipeline.groovy"
                    codePipeline  = load 'Pipeline.groovy'
			        pipeline      = codePipeline.instancia("${params.BRANCH}", _groovyBase)
                }
            }
        }
        stage ('checkout') {
            steps{
                script{
                    pipeline.gitScm.checkout()
                }
            }
        }
        stage ('build') {
            steps{
                script{
                    pipeline.buildObj.build()
                }
            }
        }
       stage ('test') {
            steps{
                script{
                    pipeline.testObj.test()
                }
            }
        }
        stage('Sonarqube') {
            when {
                //ignora passo caso nao usar sonar
                expression { pipeline.content.codeAnalise.sonar != null }
            }
             steps {
                 script{
                    pipeline.codeSonar.analise()
                 }
             }
        }
        stage ('build image docker') {
            steps{
                script {
                    pipeline.dockerBranch.build()
                    pipeline.dockerLatest.build()
				}
            }
        }
            
        stage ('push image docker') {
            steps{
                script {
                    pipeline.dockerBranch.push()
                    pipeline.dockerLatest.push()
                }
                
            }
        }
        
        stage ('deploy') {
             when {
                //ignora passo caso nao faz depoy
                expression { pipeline.content.deploy != null }
            }
            steps{
                script {
                    pipeline.deployObj.deploy()
                }
            }
        }
    }
}
