create table book (
  	bookid int primary key auto_increment,
      bookname varchar(255) not null,
      pressid int not null,
      pressdate varchar(255) not null,
      author varchar(255) not null,
      price numeric not null,
      indate varchar(255) not null,
      bookcount int not null,
      booksur int not null
  );