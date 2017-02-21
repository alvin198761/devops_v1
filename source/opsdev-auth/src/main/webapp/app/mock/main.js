'use strict';

module.exports = {

  'POST /j_spring_security_check': function (req, res) {
    console.log(req.body)
    setTimeout(function () {
      res.json({
        status: true,
        user:'alvin'
      });
    }, 500);
  } 
};
