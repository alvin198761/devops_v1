'use strict';

const devices = [];
module.exports = {

  'GET /key/exist': function (req, res) {
    setTimeout(function () {
      res.type('text')
      res.end(0)
    }, 500);
  },
  'POST /key': function (req, res) {
    setTimeout(function () {
      console.log(req.body)
      devices.push(req.body)
      res.json({code:0});
    }, 500);
  },
};
