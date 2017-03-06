/**
 * Created by tangzhichao on 2017/1/19.
 */
module.exports = function (mean, stdev) {
  var y2;
  var use_last = false;
  return function () {
    var y1;
    if (use_last) {
      y1 = y2;
      use_last = false;
    }
    else {
      var x1, x2, w;
      do {
        x1 = 2.0 * Math.random() - 1.0;
        x2 = 2.0 * Math.random() - 1.0;
        w = x1 * x1 + x2 * x2;
      } while (w >= 1.0);
      w = Math.sqrt((-2.0 * Math.log(w)) / w);
      y1 = x1 * w;
      y2 = x2 * w;
      use_last = true;
    }

    var retval = Math.ceil(mean + stdev * y1);
    if (retval > 0)
      return retval;
    return -retval;
  }
}
