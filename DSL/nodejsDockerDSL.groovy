job('Aplicacion Node.js Docker DSL') {
    description('Aplicación Node JS Docker DSL para el curso de Jenkins')
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
        dockerBuildAndPublish {
            repositoryName('gpalacios26/nodejsapp-jenkins')
            tag('${GIT_REVISION,length=7}')
            registryCredentials('docker-hub')
            forcePull(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
    publishers {
		mailer('gregpalacios26@gmail.com', true, true)
    }
}
