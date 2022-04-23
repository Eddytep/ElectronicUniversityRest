const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  devServer: {
    port: 8888,
    proxy: {
      '^/': {
        target: 'http://localhost:9000',
        ws: false,
        changeOrigin: true
      }
    }
  }
})
