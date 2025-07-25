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


CREATE TABLE Video (
    Id NVARCHAR(50) PRIMARY KEY,
    Title NVARCHAR(200) NOT NULL,
    Poster NVARCHAR(255),
    Views INT DEFAULT 0,
    Description NVARCHAR(MAX),
    Active BIT NOT NULL
);


-- Bảng Favorite
CREATE TABLE Favorite (
    Id BIGINT IDENTITY PRIMARY KEY,
    UserId NVARCHAR(50) NOT NULL,
    VideoId NVARCHAR(50) NOT NULL,
    LikeDate DATE,
    CONSTRAINT FK_Favorite_UserId FOREIGN KEY (UserId) REFERENCES Users(Id),
    CONSTRAINT FK_Favorite_VideoId FOREIGN KEY (VideoId) REFERENCES Video(Id),
    CONSTRAINT UQ_Favorite_User_Video UNIQUE (UserId, VideoId)
);

-- Bảng Share
CREATE TABLE Share (
    Id BIGINT IDENTITY PRIMARY KEY,
    UserId NVARCHAR(50) NOT NULL,
    VideoId NVARCHAR(50) NOT NULL,
    Emails NVARCHAR(500),
    ShareDate DATE,
    CONSTRAINT FK_Share_UserId FOREIGN KEY (UserId) REFERENCES Users(Id),
    CONSTRAINT FK_Share_VideoId FOREIGN KEY (VideoId) REFERENCES Video(Id)
);




INSERT INTO Users(Id, Fullname, Password, Email, Admin)
VALUES
('admin01', N'Nguyễn Văn Tèo', '123', 'teonv@fpt.edu.vn', 1),
('admin06', N'Nguyễn Văn D', '1234', 'vanD@fpt.edu.vn', 1),
('user01', N'Trần Minh Bình', '456', 'binh.tran@poly.edu', 0),
('user02', N'Lê Văn Cường', '789', 'cuong.le@poly.edu.vn', 0),
('user03', N'Phạm Thị Dung', '678', 'dung.pham@poly.edu.vn', 0),
('user04', N'Lê Thị Hoa', '111', 'hoa.le@poly.edu.vn', 0),
('user05', N'Ngô Bá Thắng', '222', 'thang.ngo@poly.edu.vn', 0),
('user06', N'Lý Văn Lộc', '333', 'loc.ly@poly.edu.vn', 0),
('user07', N'Đào Thị Mai', '444', 'mai.dao@poly.edu.vn', 0),
('user08', N'Nguyễn Văn Long', '555', 'long.nguyen@poly.edu.vn', 0),
('user09', N'Vũ Thị Thanh', '666', 'thanh.vu@poly.edu.vn', 0),
('user10', N'Trịnh Công Hậu', '777', 'hau.trinh@poly.edu.vn', 0),
('user11', N'Ngô Thanh Hà', '888', 'ha.ngo@poly.edu.vn', 0),
('user12', N'Bùi Thị Kim', '999', 'kim.bui@poly.edu.vn', 0),
('user13', N'Trần Văn Minh', '1010', 'minh.tran@poly.edu.vn', 0);


INSERT INTO Video(Id, Title, Poster, Views, Description, Active)
VALUES 
('v1', N'Kén vợ tập 3', 'kenvo.jpg', 1200, N'Tập 3 chương trình thực tế hẹn hò', 1),
('v2', N'Hài Xuân 2024', 'haixuan.jpg', 850, N'Chương trình hài đặc biệt dịp Tết', 1),
('v3', N'Phim hành động 2024', 'hanhdong.jpg', 1450, N'Trailer phim hành động hot nhất', 1),
('v4', N'Bí mật gia đình', 'gd.webp', 670, N'Tình cảm – tâm lý gia đình Việt', 1),
('v5', N'MV ca nhạc mới', 'nhactre.jpg', 1000, N'Ca khúc mới ra mắt cuối năm', 1),
('v6', N'Vlog du lịch Hà Giang', 'hagiang.jpg', 750, N'Kỷ niệm hành trình khám phá Hà Giang', 1),
('v7', N'Nấu ăn cùng mẹ', 'nauan.jpg', 620, N'Thực hiện món ngon gia đình', 1),
('v8', N'Phim hài học đường', 'haiduoing.jpg', 980, N'Tình huống vui nhộn tuổi học trò', 1),
('v9', N'MV Tết quê em', 'mv_tet.jpg', 1100, N'Ca nhạc chủ đề Tết quê hương', 1),
('v10', N'Chuyện ma có thật', 'ma.jpg', 830, N'Tổng hợp những chuyện ma nổi tiếng', 1),
('v11', N'Phóng sự lễ hội', 'lehoi.jpg', 580, N'Bản tin truyền hình lễ hội truyền thống', 1),
('v12', N'Giao lưu nghệ thuật', 'nghethuat.jpg', 690, N'Sân khấu giao lưu sinh viên', 1),
('v13', N'MV nhạc trẻ remix', 'remix.jpg', 920, N'Tuyển tập remix hot', 1),
('v14', N'Liveshow hài 2023', 'liveshow.jpg', 1040, N'Hài đặc biệt nghệ sĩ nổi tiếng', 1),
('v15', N'Trailer phim siêu anh hùng', 'trailer.jpg', 1560, N'Phim bom tấn sắp ra mắt', 1);

INSERT INTO Favorite(UserId, VideoId, LikeDate)
VALUES 
('admin01', 'v1', '2024-12-01'),
('admin01', 'v3', '2024-12-02'),
('admin01', 'v5', '2024-12-03'),

('admin06', 'v2', '2024-12-04'),
('admin06', 'v3', '2024-12-05'),
('admin06', 'v6', '2024-12-06'),

('user01', 'v1', '2024-12-07'),
('user01', 'v2', '2024-12-08'),
('user01', 'v3', '2024-12-09'),

('user02', 'v4', '2024-12-10'),
('user02', 'v5', '2024-12-11'),
('user02', 'v6', '2024-12-12'),

('user03', 'v1', '2024-12-13'),
('user03', 'v4', '2024-12-14'),
('user03', 'v7', '2024-12-15'),

('user04', 'v6', '2024-12-16'),
('user04', 'v8', '2024-12-17'),

('user05', 'v9', '2024-12-18'),
('user05', 'v10', '2024-12-19');




INSERT INTO Share(UserId, VideoId, Emails, ShareDate)
VALUES 
('admin01', 'v1', 'user01@poly.edu.vn;user02@poly.edu.vn', '2024-12-16'),
('admin06', 'v2', 'user03@poly.edu.vn', '2024-12-16'),
('user01', 'v3', 'admin01@fpt.edu.vn;admin06@fpt.edu.vn', '2024-12-16'),
('user02', 'v4', 'teonv@fpt.edu.vn', '2024-12-16'),
('user03', 'v5', 'binh.tran@poly.edu', '2024-12-16'),
('user04', 'v6', 'cuong.le@poly.edu.vn', '2024-12-17'),
('user05', 'v7', 'hoa.le@poly.edu.vn', '2024-12-17'),
('user06', 'v8', 'thang.ngo@poly.edu.vn', '2024-12-17'),
('user07', 'v9', 'loc.ly@poly.edu.vn', '2024-12-17'),
('user08', 'v10', 'dao.mai@poly.edu.vn', '2024-12-17'),
('user09', 'v11', 'long.nguyen@poly.edu.vn', '2024-12-17'),
('user10', 'v12', 'hau.trinh@poly.edu.vn', '2024-12-17'),
('user11', 'v13', 'ha.ngo@poly.edu.vn', '2024-12-17'),
('user12', 'v14', 'kim.bui@poly.edu.vn', '2024-12-17'),
('user13', 'v15', 'minh.tran@poly.edu.vn', '2024-12-17');


SELECT * FROM Favorite WHERE UserId = 'admin01';
SELECT TOP 10 * FROM Share

SELECT * FROM Video WHERE Id = 'v1';
