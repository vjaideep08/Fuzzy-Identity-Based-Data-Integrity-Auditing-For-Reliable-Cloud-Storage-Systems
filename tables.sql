CREATE TABLE `attacker` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user` text,
  `fname` text,
  `sk` text,
  `dt` text,
  `attacktype` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
CREATE TABLE `backupcloudserver` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fname` text,
  `ownername` text,
  `cname` text,
  `ct1` text,
  `mac1` text,
  `ct2` text,
  `mac2` text,
  `ct3` text,
  `mac3` text,
  `ct4` text,
  `mac4` text,
  `sk` text,
  `dt` text,
  `fsize` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=latin1;
CREATE TABLE `cloud` (
  `name` text,
  `pass` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `cloudpurchase` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cloud` text,
  `downer` text,
  `pmode` text,
  `cost` text,
  `cardn` text,
  `cvalidity` text,
  `status` text,
  `memory` text,
  `slafrom` text,
  `slato` text,
  `freemem` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
CREATE TABLE `cloudserver` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fname` text,
  `ownername` text,
  `cname` text,
  `ct1` text,
  `mac1` text,
  `ct2` text,
  `mac2` text,
  `ct3` text,
  `mac3` text,
  `ct4` text,
  `mac4` text,
  `sk` text,
  `dt` text,
  `fsize` text,
  `status` text,
  `rank` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=latin1;
CREATE TABLE `cloudstorage` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cloud` text,
  `memory` text,
  `slafrom` text,
  `slato` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
CREATE TABLE `deduplication` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` text,
  `ofname` text,
  `oblock` text,
  `dblock` text,
  `dfname` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
CREATE TABLE `deduplicator` (
  `name` text,
  `pass` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `downer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` text,
  `pass` text,
  `email` text,
  `mobile` text,
  `addr` text,
  `dob` text,
  `gender` text,
  `pin` text,
  `location` text,
  `imagess` longblob,
  `status` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
CREATE TABLE `mem_request` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cloud` text,
  `downer` text,
  `status` text,
  `memory` text,
  `slafrom` text,
  `slato` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `request` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user` text,
  `owner` text,
  `fname` text,
  `download_per` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
CREATE TABLE `search` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user` text,
  `keyword` text,
  `dt` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
CREATE TABLE `shared_files` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dupli_file` text,
  `dupli_file_owner` text,
  `shared_file` text,
  `shared_file_owner` text,
  `dt` text,
  `fsize` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
CREATE TABLE `slarequest` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cloud` text,
  `downer` text,
  `status` text,
  `memory` text,
  `slafrom` text,
  `slato` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
CREATE TABLE `transaction` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user` text,
  `fname` text,
  `task` text,
  `dt` text,
  `fsize` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=latin1;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` text,
  `pass` text,
  `email` text,
  `mobile` text,
  `addr` text,
  `dob` text,
  `gender` text,
  `pin` text,
  `location` text,
  `imagess` longblob,
  `status` text,
  `search_per` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
