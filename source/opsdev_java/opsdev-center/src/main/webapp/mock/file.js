/**
 * Created by Administrator on 2017/1/7.
 */
'use strict';
var Mock = require('mockjs')
var Random = Mock.Random;

module.exports = {

    'GET /api/file/:page': function (req, res, next) {
        const content = [];
        for (let i = 0; i < 20; i++) {
            content.push({
                id: i,
                name: Random.string('lower', 10) + ".zip",
                type: 'FILE',
                userName: Mock.mock("@name"),
                md5Path: Random.string('lower', 22),
                time: Mock.mock('@date("yyyy-MM-dd")') + " " + Random.time('HH:mm:ss')
            })
        }
        const data = {
            totalElements: 500,
            number: parseInt(req.params.page) + 1,
            size: 20,
            pageCount: 500 / 20,
            content: content
        }
        setTimeout(function () {
            res.send(data);
        }, 1000);
    },
    'GET /api/file/download/:id': function (req, res, next) {
        let content = Random.paragraph(10, 20)
        res.setHeader("Content-Length", content.length);
        res.setHeader("Content-Type", "application/force-download");
        res.setHeader("Content-Disposition", 'attachment; filename="file.txt"');
        res.write(content);
        res.end();
    },
    'POST /api/file/upload': function (req, res, next) {
        console.log(req.body)
        let data = {
            path: 'test/test.txt',
            name: 'text.txt',
            size: 123456
        };
        setTimeout(function () {
            res.send(data);
        }, 1000);
    },
    'POST /api/file': function (req, res, next) {
        console.log(req)
        setTimeout(function () {
            res.send({});
        }, 1000);
    },
    'DELETE /api/file/:id': function (req, res, next) {
        console.log(req)
        setTimeout(function () {
            res.send({});
        }, 1000);
    },
    'DELETE /api/file/delete': function (req, res, next) {
        console.log(req)
        setTimeout(function () {
            res.send({});
        }, 1000);
    },
};