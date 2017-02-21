'use strict';

module.exports = {

  'GET /heartbeat': function (req, res) {
    setTimeout(function () {
      res.json({
        success: true,
        data: 1000000,
      });
    }, 500);
  },

};
