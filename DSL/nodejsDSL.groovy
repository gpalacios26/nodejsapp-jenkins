job('Aplicacion Node.js DSL') {
    description('Aplicación Node JS DSL para el curso de Jenkins')
    scm {
        git('https://github.com/gpalacios26/nodejsapp-jenkins.git', 'master') { node ->
            node / gitConfigName('gpalacios26')
            node / gitConfigEmail('gregpalacios26@gmail.com')
        }
    }
    triggers {
        scm('H/7 * * * *')
    }
    wrappers {
        nodejs('nodejs')
    }
    steps {
        shell("npm install")
    }
    publishers {
		mailer('gregpalacios26@gmail.com', true, true)
    }
}
