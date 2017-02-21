/**
 * Created by Administrator on 2017/1/7.
 */
'use strict';
var Mock = require('mockjs')
var Random = Mock.Random;

module.exports = {

    'GET /api/room/list': function (req, res, next) {
        const data = [];
        for (let i = 0; i < 10; i++) {
            data.push({
                id: i,
                name: Random.string('lower', 10),
                address: Random.province() + " " + Mock.Random.city() + " " + Random.county(),
                manager: Mock.mock('@name'),
                remark: Random.paragraph(1)
            })
        }
        setTimeout(function () {
            res.send(data);
        }, 1000);
    },
};
