const fs = require('fs');
const path = require('path');
const webpack = require('webpack');

console.log("login --- build")


// webpackConfig.plugins[0].name = "common";
// webpackConfig.plugins[0].chunks = ["index"];

// webpackConfig.plugins.push(  new webpack.optimize.CommonsChunkPlugin({
//   name: "login-common",
//   chunks: ["login"]
// }));

module.exports = function (webpackConfig, env) {

  webpackConfig.entry = {
    login: "./src/login.js"
  }

  // webpackConfig.plugins[0].name = "login-common";
  // webpackConfig.plugins[0].filename = "login-common.js";
  // webpackConfig.plugins[0].chunks = ["login"];

  webpackConfig.plugins[0]=new webpack.optimize.CommonsChunkPlugin({
    name: "login-common",
    chunks: ["login"]
  });

  webpackConfig.babel.plugins.push('transform-runtime');
  webpackConfig.babel.plugins.push(['import', {
    libraryName: "antd",
    style: 'css',  // if true, use less
  }]);

  // Support hmr
  if (env === 'development') {
    webpackConfig.devtool = '#eval';
    webpackConfig.babel.plugins.push(['dva-hmr', {
      entries: [
        './src/index.js',
        './src/login.js',
      ],
    }]);
  } else {
    webpackConfig.babel.plugins.push('dev-expression');
  }

  // Support CSS Modules
  // Parse all less files as css module.
  webpackConfig.module.loaders.forEach(function (loader, index) {
    if (typeof loader.test === 'function' && loader.test.toString().indexOf('\\.less$') > -1) {
      loader.include = /node_modules/;
      loader.test = /\.less$/;
    }
    if (loader.test.toString() === '/\\.module\\.less$/') {
      loader.exclude = /node_modules/;
      loader.test = /\.less$/;
    }
    // if (typeof loader.test === 'function' && loader.test.toString().indexOf('\\.css$') > -1) {
    //   loader.include = /node_modules/;
    //   loader.test = /\.css$/;
    // }
    // if (loader.test.toString() === '/\\.module\\.css$/') {
    //   loader.exclude = /node_modules/;
    //   loader.test = /\.css$/;
    // }
  });
  return webpackConfig;
};
