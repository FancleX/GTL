const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true
})

module.exports = {
  outputDir: 'dist',
  assetsDir: 'static',
  // devServer: {
  //   // host: 'localhost',
  //   port: 6000,
  //   // https: false,
  //   // proxy: {
  //   //   '/api': {
  //   //     target: 'http://localhost:5000/',
  //   //     changeOrigin: true,
  //   //     ws: true,
  //   //     logLevel: "debug",
  //   //     pathRewrite: { "^/api": "" }
  //   //   },
  //   // }
  // }
}