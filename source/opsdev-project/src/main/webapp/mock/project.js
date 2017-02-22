/**
 * Created by tangzhichao on 2017/1/9.
 */
let Mock = require('mockjs');
let moment = require('moment')

module.exports = {
  "GET /api/project/list/:page": function (req, res) {
    let list = [];
    for (let i = 0; i < 20; i++) {
      list.push({
        attr: Mock.mock({
          "id": 1,
          "icon": "el-icon-menu",
          "description": /\w{15,20}\-/,
          "optUser": '@Name',
          "optPassword": /\w{6,14}\-/,
          "mail": false,
          "mailUser": "alvin198761@163.com",
          "projectStatus": "DEV"
        }),
        project: Mock.mock({
          "id": i,
          "name": /\w{5,10}\-/,
          "buildType|1-3": 1,
          "versionControl|1-2": 1,
          "author": "@Name"
        })
      });
    }
    let data = {
      page: req.params.page,
      total: 500,
      items: list
    }
    setTimeout(function () {
      res.json(data)
    }, 500)
  },
  "GET /api/project/:id": function (req, res) {
    let data = {
      id: 1,
      name: 'haha'
    }
    setTimeout(function () {
      res.json(data)
    }, 500)
  },
  "DELETE /api/project/:id": function (req, res) {
    setTimeout(function () {
      res.json({})
    }, 500)
  },
  "PUT /api/project/": function (req, res) {
    setTimeout(function () {
      res.json({})
    }, 500)
  }
};
