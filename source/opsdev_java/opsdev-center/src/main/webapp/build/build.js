// https://github.com/shelljs/shelljs
require('./check-versions')()
require('shelljs/global')
env.NODE_ENV = 'production'

var path = require('path')
var config = require('../config')
var ora = require('ora')
var webpack = require('webpack')
var webpackConfig = require('./webpack.prod.conf')

console.log(
  '  Tip:\n' +
  '  Built files are meant to be served over an HTTP server.\n' +
  '  Opening index.html over file:// won\'t work.\n'
)

var spinner = ora('building for production...')
spinner.start()

var assetsPath = path.join(config.build.assetsRoot, config.build.assetsSubDirectory)
rm('-rf', assetsPath)
mkdir('-p', assetsPath)


webpack(webpackConfig, function (err, stats) {
  spinner.stop()
  if (err) throw err
  process.stdout.write(stats.toString({
    colors: true,
    modules: false,
    children: false,
    chunks: false,
    chunkModules: false
  }) + '\n')
  console.log("----------------------------------------------------------------")
    rm('-rf','../resources/static')
    rm('-rf','../resources/templates')
    mkdir("-p" ,"../resources/templates")
    mkdir("-p" ,"../resources/static")
    cp('-r','dist/static' ,'../resources/static')
    cp('-r','dist/index.html' ,'../resources/static')
    mkdir('-p','../resources/static/static/css/static')
    mv('../resources/static/static/fonts/','../resources/static/static/css/static')
    cp('-R', 'static/*', '../resources/static/')
    cp('-r','dist/index.html' ,'../resources/templates/index.ftl')
    rm('-rf','dist')
})


