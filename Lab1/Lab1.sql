-- Tạo database
CREATE DATABASE asmjv4;
GO

USE asmjv4;
GO

CREATE TABLE Users (
    Id NVARCHAR(50) PRIMARY KEY,
    Password NVARCHAR(100) NOT NULL,
    Email NVARCHAR(100) UNIQUE NOT NULL,
    Fullname NVARCHAR(100) NOT NULL,
    Admin BIT NOT NULL
);

CREATE TABLE Logs (
    Id INT IDENTITY PRIMARY KEY,
    Url NVARCHAR(255),
    Time DATETIME,
    UserId NVARCHAR(50)
);




INSERT INTO Users(Id, Fullname, Password, Email, Admin)
VALUES
('admin01', N'Nguyễn Văn Tèo', '123', 'teonv@fpt.edu.vn', 1),
('admin06', N'Nguyễn Văn D', '1234', 'vanD@fpt.edu.vn', 1),
('user01', N'Trần Minh Bình', '456', 'binh.tran@poly.edu', 0),
('user02', N'Lê Văn Cường', '789', 'cuong.le@poly.edu.vn', 0),
('user03', N'Phạm Thị Dung', '678', 'dung.pham@poly.edu.vn', 0);


SELECT * FROM Logs ORDER BY Id DESC;
