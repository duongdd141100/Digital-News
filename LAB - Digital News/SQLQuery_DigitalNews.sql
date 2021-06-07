USE [DIGITAL_NEWS]
GO
/****** Object:  User [sa1]    Script Date: 6/7/2021 9:22:35 AM ******/
CREATE USER [sa1] FOR LOGIN [sa1] WITH DEFAULT_SCHEMA=[dbo]
GO
/****** Object:  Table [dbo].[NEWS]    Script Date: 6/7/2021 9:22:35 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NEWS](
	[ID] [int] NOT NULL,
	[NAME] [varchar](50) NULL,
	[CONTENT] [varchar](500) NULL,
	[DATE] [date] NULL,
	[WRITER] [varchar](50) NULL,
 CONSTRAINT [PK_NEWS] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[NEWS] ([ID], [NAME], [CONTENT], [DATE], [WRITER]) VALUES (1, N'News 1', N'News 1News 1News 1News 1News 1News 1News 1News 1News 1News 1News 1News 1News 1News 1News 1News 1News 1News 1News 1News 1News 1News 1News 1News 1News 1News 1News 1News 1News 1News 1News 1News 1News 1News 1News 1News 1News 1News 1News 1News 1News 1News 1News 1News 1News 1News 1News 1News 1', CAST(N'2021-05-20' AS Date), N'Do Duc Duong')
GO
INSERT [dbo].[NEWS] ([ID], [NAME], [CONTENT], [DATE], [WRITER]) VALUES (2, N'News 2', N'News 2News 2News 2News 2News 2News 2News 2News 2News 2News 2News 2News 2News 2News 2News 2News 2News 2News 2News 2News 2News 2News 2News 2News 2News 2News 2News 2News 2News 2News 2News 2News 2News 2News 2News 2News 2News 2News 2News 2News 2News 2News 2News 2News 2News 2News 2News 2News 2', CAST(N'2021-05-19' AS Date), N'Do The Tuyen')
GO
INSERT [dbo].[NEWS] ([ID], [NAME], [CONTENT], [DATE], [WRITER]) VALUES (3, N'News 3', N'News 3News 3News 3News 3News 3News 3News 3News 3News 3News 3News 3News 3News 3News 3News 3News 3News 3News 3News 3News 3News 3News 3News 3News 3News 3News 3News 3News 3News 3News 3News 3News 3News 3News 3News 3News 3News 3News 3News 3News 3News 3News 3News 3News 3News 3News 3News 3News 3', CAST(N'2021-05-18' AS Date), N'Do The Quyen')
GO
INSERT [dbo].[NEWS] ([ID], [NAME], [CONTENT], [DATE], [WRITER]) VALUES (4, N'News 4', N'News 4News 4News 4News 4News 4News 4News 4News 4News 4News 4News 4News 4News 4News 4News 4News 4News 4News 4News 4News 4News 4News 4News 4News 4News 4News 4News 4News 4News 4News 4News 4News 4News 4News 4News 4News 4News 4News 4News 4News 4News 4News 4News 4News 4News 4News 4News 4News 4', CAST(N'2021-05-17' AS Date), N'Do Quang Thach')
GO
INSERT [dbo].[NEWS] ([ID], [NAME], [CONTENT], [DATE], [WRITER]) VALUES (5, N'News 5', N'News 5News 5News 5News 5News 5News 5News 5News 5News 5News 5News 5News 5News 5News 5News 5News 5News 5News 5News 5News 5News 5News 5News 5News 5News 5News 5News 5News 5News 5News 5News 5News 5News 5News 5News 5News 5News 5News 5News 5News 5News 5News 5News 5News 5News 5News 5News 5News 5', CAST(N'2021-05-16' AS Date), N'Do Quang Thuc')
GO
INSERT [dbo].[NEWS] ([ID], [NAME], [CONTENT], [DATE], [WRITER]) VALUES (6, N'News 6', N'News 6News 6News 6News 6News 6News 6News 6News 6News 6News 6News 6News 6News 6News 6News 6News 6News 6News 6News 6News 6News 6News 6News 6News 6News 6News 6News 6News 6News 6News 6News 6News 6News 6News 6News 6News 6News 6News 6News 6News 6News 6News 6News 6News 6News 6News 6News 6News 6', CAST(N'2021-05-15' AS Date), N'Do Toan')
GO
INSERT [dbo].[NEWS] ([ID], [NAME], [CONTENT], [DATE], [WRITER]) VALUES (7, N'News 7', N'News 7News 7News 7News 7News 7News 7News 7News 7News 7News 7News 7News 7News 7News 7News 7News 7News 7News 7News 7News 7News 7News 7News 7News 7News 7News 7News 7News 7News 7News 7News 7News 7News 7News 7News 7News 7News 7News 7News 7News 7News 7News 7News 7News 7News 7News 7News 7News 7', CAST(N'2021-05-14' AS Date), N'Do Duc Giang')
GO
INSERT [dbo].[NEWS] ([ID], [NAME], [CONTENT], [DATE], [WRITER]) VALUES (8, N'News 8', N'News 8News 8News 8News 8News 8News 8News 8News 8News 8News 8News 8News 8News 8News 8News 8News 8News 8News 8News 8News 8News 8News 8News 8News 8News 8News 8News 8News 8News 8News 8News 8News 8News 8News 8News 8News 8News 8News 8News 8News 8News 8News 8News 8News 8News 8News 8News 8News 8', CAST(N'2021-05-13' AS Date), N'Do Duc Duong')
GO
INSERT [dbo].[NEWS] ([ID], [NAME], [CONTENT], [DATE], [WRITER]) VALUES (9, N'News 9', N'News 9News 9News 9News 9News 9News 9News 9News 9News 9News 9News 9News 9News 9News 9News 9News 9News 9News 9News 9News 9News 9News 9News 9News 9News 9News 9News 9News 9News 9News 9News 9News 9News 9News 9News 9News 9News 9News 9News 9News 9News 9News 9News 9News 9News 9News 9News 9News 9', CAST(N'2021-05-12' AS Date), N'Do Duc Duong')
GO
