'use strict';

const devices = {
  "content": [{
    "id": 1,
    "innerServer": "192.168.1.1",
    "outServer": "110.110.111.111",
    "port": 22,
    "key": null,
    "type": "COMPUTER",
    "os": "WINDOWS",
    "arch": "X86"
  }],
  "last": true,
  "totalElements": 1,
  "totalPages": 1,
  "number": 0,
  "size": 20,
  "sort": [{"direction": "DESC", "property": "id", "ignoreCase": false, "nullHandling": "NATIVE", "ascending": false}],
  "first": true,
  "numberOfElements": 1
};

module.exports = {

  'GET /device': function (req, res) {
    setTimeout(function () {
      res.json(devices);
    }, 500);
  },

  'POST /device': function (req, res) {
    setTimeout(function () {
      console.log(req.body)
      devices.content.push(req.body);
      res.json(devices);
    }, 500);
  },

  'POST /device/editIp': function (req, res) {
    setTimeout(function () {
      console.log(req.body)
      res.json(devices);
    }, 500);
  },
  'DELETE /device/{id}': function (req, res) {
    setTimeout(function () {
      console.log(req.body)
      res.json(devices);
    }, 500);
  },

};
