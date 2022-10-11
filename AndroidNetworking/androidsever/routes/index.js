var express = require('express');
var fs = require('fs');
var multer  = require('multer');
var storage = multer.diskStorage({
  destination: function(req, file, cb) {
    cb(null, 'upload');
  },
  filename: function(req, file, cb) {
    cb(null, Date.now() + '-' + file.originalname);
  },
});

const upload = multer({ storage: storage });

var router = express.Router();
/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('index', { title: 'Express' });
});

router.get('/getUsers', function(req, res, next) {
  fs.readFile('data/data.txt',function (err,data) {
    if (err != null){
      res.send(err.message);
    }else {
      res.send(data.toString());
    }
    })
});
router.post('/createUser',upload.single('avatar'),function (req,res){
  var email = req.body.email;
  var password = req.body.password;

  var data = {
    email : undefined,
    password :undefined,
    avatar : undefined,
    urlavatar : undefined
  }
  data.email = email;
  data.password = password;
  data.avatar = req.file.originalname;
  data.urlavatar = req.file.path;

  res.send(data);
})

module.exports = router;
