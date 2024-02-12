insert into TWEETER values(?,?,?);

create table TWEETER(EMAIL varchar(40) not null primary key, NAME varchar(30) not null, PASSWORD varchar(20) not null);

create table TWEET(TWEET_ID int not null auto_increment primary key, EMAIL varchar(40) not null, TWEET varchar(150) not null, TIME_OF_TWEET timestamp not null, RETWEET_OF_TWEET_ID int not null default -1, LIKES int not null default 0, NUMBER_OF_COMMENTS int not null default 0);

create table COMMENTS(COMMENT_ID int not null auto_increment primary key, TWEET_ID int not null, COMMENT varchar(150) not null);
