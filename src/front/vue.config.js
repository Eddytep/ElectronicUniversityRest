module.exports = {
    devServer: {
        port: 8888,
        // proxy: 'http://localhost:9000'
        proxy: {
            '^/': {
                target: 'http://localhost:9000'
            }
        }
    }
}