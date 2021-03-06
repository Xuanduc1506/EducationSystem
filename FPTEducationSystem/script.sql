USE [EducationSystem]
GO
/****** Object:  Table [dbo].[Account]    Script Date: 7/10/2021 8:06:07 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Account](
	[username] [nvarchar](50) NOT NULL,
	[password] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Account] PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Department]    Script Date: 7/10/2021 8:06:07 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Department](
	[id] [int] NOT NULL,
	[name] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Department] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Request]    Script Date: 7/10/2021 8:06:07 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Request](
	[id] [int] NOT NULL,
	[studentID] [nvarchar](50) NOT NULL,
	[studentName] [nvarchar](50) NOT NULL,
	[id_Department] [int] NOT NULL,
	[dateCreated] [nvarchar](50) NOT NULL,
	[title] [nvarchar](50) NOT NULL,
	[content] [text] NOT NULL,
	[status] [nvarchar](50) NOT NULL,
	[closeDate] [nvarchar](50) NOT NULL,
	[detail] [bit] NOT NULL,
	[solution] [text] NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
INSERT [dbo].[Account] ([username], [password]) VALUES (N'admin', N'123')
INSERT [dbo].[Account] ([username], [password]) VALUES (N'ducnx', N'123')
INSERT [dbo].[Department] ([id], [name]) VALUES (1, N'Department1')
INSERT [dbo].[Department] ([id], [name]) VALUES (2, N'Department2')
INSERT [dbo].[Department] ([id], [name]) VALUES (3, N'Department3')
INSERT [dbo].[Department] ([id], [name]) VALUES (4, N'Department4')
INSERT [dbo].[Department] ([id], [name]) VALUES (5, N'Department5')
INSERT [dbo].[Department] ([id], [name]) VALUES (6, N'Department6')
INSERT [dbo].[Department] ([id], [name]) VALUES (7, N'Department7')
INSERT [dbo].[Department] ([id], [name]) VALUES (8, N'Department8')
INSERT [dbo].[Request] ([id], [studentID], [studentName], [id_Department], [dateCreated], [title], [content], [status], [closeDate], [detail], [solution]) VALUES (1, N'1', N'a', 1, N'2021-06-23', N'asdasdasdasdasdasd', N'asdadadadsadasdadsadsadasdadsadsadasd', N'Reject', N'2021-07-07', 1, N'dddd')
INSERT [dbo].[Request] ([id], [studentID], [studentName], [id_Department], [dateCreated], [title], [content], [status], [closeDate], [detail], [solution]) VALUES (2, N'2', N'b', 1, N'2021-06-23', N'asdasdasdasd', N'asdasdsadasdasdasdasdasdasdasdasdsad', N'in progress', N'N/A', 1, N'a')
INSERT [dbo].[Request] ([id], [studentID], [studentName], [id_Department], [dateCreated], [title], [content], [status], [closeDate], [detail], [solution]) VALUES (3, N'3', N'c', 2, N'2021-06-23', N'asdadssad', N'asdasdsadsadasdsad', N'in progress', N'N/A', 0, N'a')
INSERT [dbo].[Request] ([id], [studentID], [studentName], [id_Department], [dateCreated], [title], [content], [status], [closeDate], [detail], [solution]) VALUES (4, N'3', N'c', 2, N'2021-06-21', N'asdas', N'asdasdasdasdasdasdasdasdas', N'in progress', N'N/A', 0, N'a')
INSERT [dbo].[Request] ([id], [studentID], [studentName], [id_Department], [dateCreated], [title], [content], [status], [closeDate], [detail], [solution]) VALUES (5, N'4', N'r', 3, N'2021-06-23', N'asdada', N'adasdasdadsadadsadasdasdasdasdasd', N'in progress', N'N/A', 1, N'a')
INSERT [dbo].[Request] ([id], [studentID], [studentName], [id_Department], [dateCreated], [title], [content], [status], [closeDate], [detail], [solution]) VALUES (6, N'5', N'h', 3, N'2021-06-23', N'asdas', N'asdasdadsadasdafdsvsvs', N'Reject', N'2021-07-07', 1, N'bbbbbb')
INSERT [dbo].[Request] ([id], [studentID], [studentName], [id_Department], [dateCreated], [title], [content], [status], [closeDate], [detail], [solution]) VALUES (7, N'6', N'g', 4, N'2021-06-20', N'adsas', N'asdadsasdsadasdsadsadsadsadasdasdasdasd', N'in progress', N'N/A', 0, N'a')
INSERT [dbo].[Request] ([id], [studentID], [studentName], [id_Department], [dateCreated], [title], [content], [status], [closeDate], [detail], [solution]) VALUES (8, N'6', N'g', 5, N'2021-06-23', N'asdasd', N'asdsadadsasdasdsadadsadadasd', N'in progress', N'N/A', 0, N'a')
INSERT [dbo].[Request] ([id], [studentID], [studentName], [id_Department], [dateCreated], [title], [content], [status], [closeDate], [detail], [solution]) VALUES (9, N'7', N'j', 6, N'2021-06-23', N'asdasd', N'asdasdasdsadasdasdadasdasdasadadadadasd', N'in progress', N'N/A', 0, N'a')
INSERT [dbo].[Request] ([id], [studentID], [studentName], [id_Department], [dateCreated], [title], [content], [status], [closeDate], [detail], [solution]) VALUES (10, N'7', N'j', 7, N'2021-06-23', N'asdads', N'ASDASDASDADSADASDASDASASDASDASD', N'in progress', N'N/A', 0, N'a')
INSERT [dbo].[Request] ([id], [studentID], [studentName], [id_Department], [dateCreated], [title], [content], [status], [closeDate], [detail], [solution]) VALUES (11, N'8', N'k', 8, N'2021-06-23', N'asd', N'asdasdasdadsasdsadasdasdasdasdasdasd', N'in progress', N'N/A', 0, N'a')
INSERT [dbo].[Request] ([id], [studentID], [studentName], [id_Department], [dateCreated], [title], [content], [status], [closeDate], [detail], [solution]) VALUES (12, N'9', N'p', 8, N'2021-06-23', N'g', N'gggggggggggggggggggggggggg', N'Approved', N'2021-07-07', 1, N'aaa')
