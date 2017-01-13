-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 17, 2016 at 04:52 AM
-- Server version: 10.1.10-MariaDB
-- PHP Version: 7.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `quanlykho`
--

-- --------------------------------------------------------

--
-- Table structure for table `chitietnhap`
--

CREATE TABLE `chitietnhap` (
  `SoPhieuNhap` varchar(10) NOT NULL,
  `MaHang` varchar(10) NOT NULL,
  `SoLuongNhap` int(11) NOT NULL,
  `DonGia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `chitietnhap`
--

INSERT INTO `chitietnhap` (`SoPhieuNhap`, `MaHang`, `SoLuongNhap`, `DonGia`) VALUES
('SPN01', 'MH01', 20, 55000),
('SPN02', 'MH03', 45, 20000),
('SPN03', 'MH05', 28, 215000);

-- --------------------------------------------------------

--
-- Table structure for table `chitietxuat`
--

CREATE TABLE `chitietxuat` (
  `SoPhieuXuat` varchar(10) NOT NULL,
  `MaHang` varchar(10) NOT NULL,
  `SoLuongXuat` int(11) NOT NULL,
  `DonGia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `chitietxuat`
--

INSERT INTO `chitietxuat` (`SoPhieuXuat`, `MaHang`, `SoLuongXuat`, `DonGia`) VALUES
('SPX01', 'MH01', 8, 80000),
('SPX02', 'MH03', 14, 45000),
('SPX03', 'MH05', 7, 245000);

-- --------------------------------------------------------

--
-- Table structure for table `hanghoa`
--

CREATE TABLE `hanghoa` (
  `MaHang` varchar(10) NOT NULL,
  `TenHang` varchar(20) NOT NULL,
  `SoLuong` int(11) NOT NULL,
  `DonViTinh` varchar(10) NOT NULL,
  `DonGia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hanghoa`
--

INSERT INTO `hanghoa` (`MaHang`, `TenHang`, `SoLuong`, `DonViTinh`, `DonGia`) VALUES
('MH01', 'Xi mang', 20, 'bao', 55000),
('MH02', 'Sat', 12, 'Cay', 180000),
('MH03', 'Tam Lop', 45, 'cai', 20000),
('MH05', 'Son Apech', 28, 'hop', 215000);

-- --------------------------------------------------------

--
-- Table structure for table `khachhang`
--

CREATE TABLE `khachhang` (
  `MaKhach` varchar(10) NOT NULL,
  `TenKhach` varchar(20) NOT NULL,
  `DiaChi` varchar(30) NOT NULL,
  `SoDienThoai` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `khachhang`
--

INSERT INTO `khachhang` (`MaKhach`, `TenKhach`, `DiaChi`, `SoDienThoai`) VALUES
('MK01', 'Nguyen Thi Lan', 'Trai Cau-Dong Hy-Thai nguyen', '0967287172'),
('MK02', 'Nong Thi Ha', 'Nam Hoa-Dong Hy-Thai Nguyen', '0912576830'),
('MK03', 'Nguyen VanThanh', 'Cay Thi-Dong Hy', '0967096193');

-- --------------------------------------------------------

--
-- Table structure for table `nhacungcap`
--

CREATE TABLE `nhacungcap` (
  `MaNCC` varchar(10) NOT NULL,
  `TenNCC` varchar(20) NOT NULL,
  `DiaChi` varchar(30) NOT NULL,
  `SoDienThoai` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `nhacungcap`
--

INSERT INTO `nhacungcap` (`MaNCC`, `TenNCC`, `DiaChi`, `SoDienThoai`) VALUES
('MN01', 'Xi Mang La Hien', 'Dong Hy- Thai Nguyen', '0985565333'),
('MN03', 'Cong ty Gach op lat', 'Dong Anh- Ha Noi', '0912373888'),
('MN04', 'Cong ty Son Lucky', 'Soc Son - Ha Noi', '0912721180'),
('MN05', 'Cong ty Son SUCC', 'Soc Son- Ha Noi', '0986662444');

-- --------------------------------------------------------

--
-- Table structure for table `phieunhap`
--

CREATE TABLE `phieunhap` (
  `SoPhieuNhap` varchar(10) NOT NULL,
  `NgayNhap` date NOT NULL,
  `MaNCC` varchar(10) NOT NULL,
  `ThanhTien` int(11) DEFAULT '0',
  `DienGiai` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `phieunhap`
--

INSERT INTO `phieunhap` (`SoPhieuNhap`, `NgayNhap`, `MaNCC`, `ThanhTien`, `DienGiai`) VALUES
('SPN01', '2016-04-08', 'MN01', 1100000, ''),
('SPN02', '2016-04-10', 'MN03', 900000, ''),
('SPN03', '2016-03-07', 'MN05', 6020000, NULL);

-- --------------------------------------------------------

--
-- Stand-in structure for view `phieunhapview`
--
CREATE TABLE `phieunhapview` (
`SoPhieuNhap` varchar(10)
,`NgayNhap` date
,`MaNCC` varchar(10)
,`TenNCC` varchar(20)
);

-- --------------------------------------------------------

--
-- Table structure for table `phieuxuat`
--

CREATE TABLE `phieuxuat` (
  `SoPhieuXuat` varchar(10) NOT NULL,
  `NgayXuat` date NOT NULL,
  `MaKhach` varchar(10) NOT NULL,
  `ThanhTien` int(11) DEFAULT '0',
  `DienGiai` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `phieuxuat`
--

INSERT INTO `phieuxuat` (`SoPhieuXuat`, `NgayXuat`, `MaKhach`, `ThanhTien`, `DienGiai`) VALUES
('SPX01', '2015-12-17', 'MK02', 640000, ''),
('SPX02', '2016-04-04', 'MK04', 630000, ''),
('SPX03', '2016-05-02', 'MK05', 1715000, '');

-- --------------------------------------------------------

--
-- Stand-in structure for view `phieuxuatview`
--
CREATE TABLE `phieuxuatview` (
`SoPhieuXuat` varchar(10)
,`NgayXuat` date
,`MaKhach` varchar(10)
,`TenKhach` varchar(20)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `thongkenhap`
--
CREATE TABLE `thongkenhap` (
`MaHang` varchar(10)
,`TenHang` varchar(20)
,`SoLuongNhap` int(11)
,`DonViTinh` varchar(10)
,`ThanhTien` bigint(21)
,`NgayNhap` date
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `thongketon`
--
CREATE TABLE `thongketon` (
`MaHang` varchar(10)
,`TenHang` varchar(20)
,`SoLuongNhap` int(11)
,`SoLuongXuat` int(11)
,`Tongton` bigint(12)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `thongkexuat`
--
CREATE TABLE `thongkexuat` (
`MaHang` varchar(10)
,`TenHang` varchar(20)
,`SoLuongXuat` int(11)
,`DonViTinh` varchar(10)
,`ThanhTien` bigint(21)
,`NgayXuat` date
);

-- --------------------------------------------------------

--
-- Table structure for table `userlogin`
--

CREATE TABLE `userlogin` (
  `id` int(11) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `userlogin`
--

INSERT INTO `userlogin` (`id`, `username`, `password`) VALUES
(1, 'admin', 'admin');

-- --------------------------------------------------------

--
-- Structure for view `phieunhapview`
--
DROP TABLE IF EXISTS `phieunhapview`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `phieunhapview`  AS  select `phieunhap`.`SoPhieuNhap` AS `SoPhieuNhap`,`phieunhap`.`NgayNhap` AS `NgayNhap`,`nhacungcap`.`MaNCC` AS `MaNCC`,`nhacungcap`.`TenNCC` AS `TenNCC` from (`nhacungcap` join `phieunhap`) where (`nhacungcap`.`MaNCC` = `phieunhap`.`MaNCC`) ;

-- --------------------------------------------------------

--
-- Structure for view `phieuxuatview`
--
DROP TABLE IF EXISTS `phieuxuatview`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `phieuxuatview`  AS  select `phieuxuat`.`SoPhieuXuat` AS `SoPhieuXuat`,`phieuxuat`.`NgayXuat` AS `NgayXuat`,`khachhang`.`MaKhach` AS `MaKhach`,`khachhang`.`TenKhach` AS `TenKhach` from (`khachhang` join `phieuxuat`) where (`khachhang`.`MaKhach` = `phieuxuat`.`MaKhach`) ;

-- --------------------------------------------------------

--
-- Structure for view `thongkenhap`
--
DROP TABLE IF EXISTS `thongkenhap`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `thongkenhap`  AS  select `chitietnhap`.`MaHang` AS `MaHang`,`hanghoa`.`TenHang` AS `TenHang`,`chitietnhap`.`SoLuongNhap` AS `SoLuongNhap`,`hanghoa`.`DonViTinh` AS `DonViTinh`,(`chitietnhap`.`DonGia` * `chitietnhap`.`SoLuongNhap`) AS `ThanhTien`,`phieunhap`.`NgayNhap` AS `NgayNhap` from (`phieunhap` join (`chitietnhap` join `hanghoa` on((`hanghoa`.`MaHang` = `chitietnhap`.`MaHang`)))) where (`phieunhap`.`SoPhieuNhap` = `chitietnhap`.`SoPhieuNhap`) ;

-- --------------------------------------------------------

--
-- Structure for view `thongketon`
--
DROP TABLE IF EXISTS `thongketon`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `thongketon`  AS  select `thongkenhap`.`MaHang` AS `MaHang`,`thongkenhap`.`TenHang` AS `TenHang`,`thongkenhap`.`SoLuongNhap` AS `SoLuongNhap`,`thongkexuat`.`SoLuongXuat` AS `SoLuongXuat`,(`thongkenhap`.`SoLuongNhap` - `thongkexuat`.`SoLuongXuat`) AS `Tongton` from (`thongkenhap` join `thongkexuat`) where (`thongkenhap`.`MaHang` = `thongkexuat`.`MaHang`) ;

-- --------------------------------------------------------

--
-- Structure for view `thongkexuat`
--
DROP TABLE IF EXISTS `thongkexuat`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `thongkexuat`  AS  select `chitietxuat`.`MaHang` AS `MaHang`,`hanghoa`.`TenHang` AS `TenHang`,`chitietxuat`.`SoLuongXuat` AS `SoLuongXuat`,`hanghoa`.`DonViTinh` AS `DonViTinh`,(`chitietxuat`.`DonGia` * `chitietxuat`.`SoLuongXuat`) AS `ThanhTien`,`phieuxuat`.`NgayXuat` AS `NgayXuat` from (`phieuxuat` join (`chitietxuat` join `hanghoa` on((`hanghoa`.`MaHang` = `chitietxuat`.`MaHang`)))) where (`phieuxuat`.`SoPhieuXuat` = `chitietxuat`.`SoPhieuXuat`) ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `chitietnhap`
--
ALTER TABLE `chitietnhap`
  ADD PRIMARY KEY (`SoPhieuNhap`),
  ADD UNIQUE KEY `MaHang` (`MaHang`);

--
-- Indexes for table `chitietxuat`
--
ALTER TABLE `chitietxuat`
  ADD PRIMARY KEY (`SoPhieuXuat`),
  ADD UNIQUE KEY `MaHang` (`MaHang`);

--
-- Indexes for table `hanghoa`
--
ALTER TABLE `hanghoa`
  ADD PRIMARY KEY (`MaHang`);

--
-- Indexes for table `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`MaKhach`);

--
-- Indexes for table `nhacungcap`
--
ALTER TABLE `nhacungcap`
  ADD PRIMARY KEY (`MaNCC`);

--
-- Indexes for table `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD PRIMARY KEY (`SoPhieuNhap`),
  ADD UNIQUE KEY `MaNCC` (`MaNCC`);

--
-- Indexes for table `phieuxuat`
--
ALTER TABLE `phieuxuat`
  ADD PRIMARY KEY (`SoPhieuXuat`),
  ADD UNIQUE KEY `MaKhach` (`MaKhach`);

--
-- Indexes for table `userlogin`
--
ALTER TABLE `userlogin`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `userlogin`
--
ALTER TABLE `userlogin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
