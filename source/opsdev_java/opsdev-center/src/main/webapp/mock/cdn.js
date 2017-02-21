'use strict';
var Mock = require('mockjs')
var Random = Mock.Random;

module.exports = {

    'GET /api/cdn/:page': function (req, res, next) {
        const content = [];
        for (let i = 0; i < 20; i++) {
            content.push({
                id: i,
                file: Random.string(5, 6) + '.txt',
                hosts: '牛逼1，很牛逼2',
                target: '/test/nb.txt',
                time: '2100-1-1 12:12:12',
                user: Mock.mock("@name"),
                status: Mock.Random.integer(1, 3)
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
    'GET /api/cdn/cancel/:id': function (req, res, next) {
        console.log(req.query)
        setTimeout(function () {
            res.send({});
        }, 1000);
    },
    'GET /api/cdn/retry/:id': function (req, res, next) {
        console.log(req.query)
        setTimeout(function () {
            res.send({});
        }, 1000);
    },
    'GET /api/cdn/files': function (req, res, next) {
        let files = [
            {
                id: 1,
                label: '文件夹1',
                children: [{
                    id: 2,
                    label: 'text.txt'
                }]
            }, {
                id: 3,
                label: '一级 2',
                children: [{
                    id: 4,
                    label: '二级 2-1'
                }, {
                    id: 5,
                    label: '二级 2-2'
                }]
            }, {
                id: 6,
                label: '一级 3',
                children: [{
                    id: 7,
                    label: '二级 3-1'
                }, {
                    id: 8,
                    label: '二级 3-2'
                }]
            }
        ];
        setTimeout(function () {
            res.json(files);
        }, 1000);
    },
    'GET /api/cdn/hosts': function (req, res, next) {
        console.log(req.query)
        let data = [];
        for (let i = 0; i < 10; i++) {
            data.push({
                id: i,
                name: Mock.Random.string(5, 10)
            })
        }
        setTimeout(function () {
            res.send(data);
        }, 1000);
    },
}