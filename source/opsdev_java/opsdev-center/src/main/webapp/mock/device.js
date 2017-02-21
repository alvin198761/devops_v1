/**
 * Created by Administrator on 2017/1/7.
 */
'use strict';
var Mock = require('mockjs')
var Random = Mock.Random;

module.exports = {

    'GET /api/device/list/:page': function (req, res, next) {
        const content = [];
        for (let i = 0; i < 20; i++) {
            content.push({
                id: i,
                innerIp: Mock.mock('@ip'),
                outerIp: Mock.mock('@ip'),
                port: Mock.mock({
                    "number|1-100": 100
                }),
                room: {
                    name: Random.string('lower', 10)
                },
                remark: Random.paragraph(1),
                key: {
                    user: Mock.mock('@name')
                }
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
};