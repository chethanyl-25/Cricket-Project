-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 18, 2023 at 07:37 AM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.0.14

SET FOREIGN_KEY_CHECKS=0;
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cricscorer`
--

--
-- Dumping data for table `match_details`
--

INSERT INTO `match_details` (`match_id`, `overs`, `result`, `status`, `toss_selection`, `umpires`, `man_of_the_match`, `team_a`, `team_b`, `toss_won`, `won_by`) VALUES
(1, 3, 'India won by 34 runs', 'Completed', 'bat', 'Ravi Shastri, Davidson', 1, 1, 2, 1, 1),
(2, 5, NULL, 'upcoming', NULL, NULL, NULL, 3, 4, NULL, NULL),
(4, 20, NULL, 'upcoming', NULL, NULL, NULL, 7, 8, NULL, NULL);

--
-- Dumping data for table `match_seq`
--

INSERT INTO `match_seq` (`next_val`) VALUES
(1),
(1),
(5);

--
-- Dumping data for table `player`
--

INSERT INTO `player` (`player_id`, `batting_style`, `bowling_style`, `name`, `nationality`, `role`) VALUES
(1, 'Right Hand', NULL, 'K L RAHUL', 'Indian', 'Batsman'),
(2, 'Right Hand', NULL, 'Rohith Sharma', 'Indian', 'Batsman'),
(3, 'Right Hand', NULL, 'Virat Kohli', 'Indian', 'Batsman'),
(4, 'Right Hand', NULL, 'Surya Kumar Yadav ', 'Indian', 'Batsman'),
(5, 'Right Hand', NULL, 'Shreyas Iyer ', 'Indian', 'Batsman'),
(6, 'Left Hand', NULL, 'Rishabn Pant', 'Indian', 'Batsman'),
(7, 'Left Hand', 'Left-arm Spin', 'Ravindra Jadeja', 'Indian', 'All-Rounder'),
(8, 'Right Hand', 'Right-arm Medium', 'Hardhik Pandya', 'Indian', 'All-Rounder'),
(9, 'Right Hand', 'Right-arm Fast', 'Mohammed Shami', 'Indian', 'Bowler'),
(10, 'Right Hand', 'Right-arm Fast', 'Mohammed Siraj', 'Indian', 'Bowler'),
(11, 'Right Hand', 'Right-arm Leg Spin', 'Yuzvendra Chahal', 'Indian', 'Bowler'),
(12, 'Right Hand', NULL, 'Shubman Gill', 'Indian', 'Batsman'),
(13, 'Right Hand', 'Right-arm Off-Spin', 'Ravichandran Ashwin', 'Indian', 'All-Rounder'),
(14, 'Left Hand', 'Left-arm Fast', 'Arshdeep Singh', 'Indian', 'Bowler'),
(15, 'RightvHand', 'Right-arm Fast', 'Jasprit Bumrah', 'Indian', 'Bowler'),
(16, 'Right Hand', 'Right-arm Fast', 'Pat Cummins', 'Australia', 'Bowler'),
(17, 'Right Hand', 'Right-arm Fast', 'Josh Hazelwood', 'Australia', 'Bowler'),
(18, 'Left Hand', 'Left-arm Fast', 'Michel Starc', 'Australia', 'Bowler'),
(19, 'Right Hand', 'Right-arm Fast', 'Cameron Green', 'Australia', 'All-Rounder'),
(20, 'Right Hand', 'Right-arm leg Spin', 'Adam Zampa', 'Australia', 'bowler'),
(21, 'Left Hand', 'Left-arm Spin', 'Aston Agar', 'Australia', 'Bowler'),
(22, 'Right Hand', 'Right-arm Spin', 'Glen Maxwell', 'Australia', 'All-Rounder'),
(23, 'Left Hand', NULL, 'Alex Crey', 'Australia', 'Batsman'),
(24, 'Left Hand', NULL, 'David Warner', 'Australia', 'Batsman'),
(25, 'Left Hand', NULL, 'Usman Khawaja', 'Australia', 'Batsman'),
(26, 'Right Hand', NULL, 'Steve Smith', 'Australia', 'Batsman'),
(27, 'Right Hand', NULL, 'Marnus Labuschane', 'Australia', 'Batsman'),
(28, 'Right Hand', 'Right-arm Fast', 'Marcus Stoinis', 'Australia', 'All-Rounder'),
(29, 'Right Hand', NULL, 'Josh Inglis', 'Australia', 'Batsman'),
(30, 'Right Hand', NULL, 'Anil', 'Indian', 'Batsman'),
(31, 'Right hand', NULL, 'Avishka Fernando', 'Sri Lanka', 'Batsman'),
(32, 'Right hand', NULL, 'Pathum Nisanka', 'Sri Lanka', 'Batsman'),
(33, 'Right hand', NULL, 'Kusal Mendis', 'Sri Lanka', 'Batsman'),
(34, 'Right hand', NULL, ' Kusal Perera', 'Sri Lanka', 'Batsman'),
(35, 'Right hand', NULL, ' Dhananjaya deSilva', 'Sri Lanka', 'Batsman'),
(36, 'Right hand', 'Right Arm Fast', ' Asalanka', 'Sri Lanka', 'All Rounder'),
(37, 'Right hand', 'Right Arm Fast', ' Shanaka', 'Sri Lanka', 'All Rounder'),
(38, 'Right hand', 'Right Arm Fast', ' Hasaranga', 'Sri Lanka', 'All Rounder'),
(39, 'Right hand', 'Right Off Spin', ' Theeksahna', 'Sri Lanka', 'Bowler'),
(40, 'Right hand', 'Right Arm Fast', 'Rajatha', 'Sri Lanka', 'Bowler'),
(41, 'Right hand', 'Right Arm Fast', 'Lahiru Kumara', 'Sri Lanka', 'Bowler'),
(42, 'Left hand', 'Left Arm Fast', 'Madhusudan', 'Sri Lanka', 'Bowler'),
(43, 'Left hand', 'Left Arm Fast', 'Karunarathne', 'Sri Lanka', 'All rounder');

--
-- Dumping data for table `player_seq`
--

INSERT INTO `player_seq` (`next_val`) VALUES
(44);

--
-- Dumping data for table `score_details`
--

INSERT INTO `score_details` (`ball_id`, `ball_no`, `creation_time`, `event`, `overs`, `runs`, `batting_team_id`, `bowler_id`, `bowling_team_id`, `match_id`, `non_striker_id`, `striker_id`, `wicket_id`) VALUES
(1, 1, '2023-04-13 12:23:21', 'normal', 0, 6, 1, 18, 2, 1, 7, 1, NULL),
(2, 2, NULL, 'normal', 0, 2, 1, 18, 2, 1, 7, 1, NULL),
(3, 3, NULL, 'normal', 0, 1, 1, 18, 2, 1, 7, 1, NULL),
(4, 4, NULL, 'wicket', 0, 0, 1, 18, 2, 1, 1, 7, 1),
(5, 5, NULL, 'wide', 0, 1, 1, 18, 2, 1, 1, 3, NULL),
(6, 5, NULL, 'wicket', 0, 0, 1, 18, 2, 1, 1, 3, 2),
(7, 0, NULL, 'normal', 1, 0, 1, 18, 2, 1, 1, 4, NULL),
(8, 1, NULL, 'normal', 1, 2, 1, 16, 2, 1, 4, 1, NULL),
(9, 2, NULL, 'normal', 1, 0, 1, 16, 2, 1, 4, 1, NULL),
(10, 3, NULL, 'wide', 1, 0, 1, 16, 2, 1, 4, 1, NULL),
(11, 3, NULL, 'normal', 1, 1, 1, 16, 2, 1, 4, 1, NULL),
(12, 4, NULL, 'normal', 1, 4, 1, 16, 2, 1, 1, 4, NULL),
(13, 5, NULL, 'normal', 1, 6, 1, 16, 2, 1, 1, 4, NULL),
(14, 0, NULL, 'wicket', 2, 0, 1, 16, 2, 1, 1, 4, 3),
(15, 1, NULL, 'normal', 2, 2, 1, 16, 2, 1, 5, 1, NULL),
(16, 2, NULL, 'normal', 2, 4, 1, 16, 2, 1, 5, 1, NULL),
(17, 3, NULL, 'normal', 2, 1, 1, 16, 2, 1, 5, 1, NULL),
(18, 4, NULL, 'normal', 2, 1, 1, 16, 2, 1, 1, 5, NULL),
(19, 5, NULL, 'normal', 2, 2, 1, 16, 2, 1, 5, 1, NULL),
(21, 1, NULL, 'normal', 0, 2, 2, 9, 1, 1, 26, 24, NULL),
(22, 2, NULL, 'normal', 0, 0, 2, 9, 1, 1, 26, 24, NULL),
(23, 3, NULL, 'normal', 0, 1, 2, 9, 1, 1, 26, 24, NULL),
(24, 4, NULL, 'normal', 0, 4, 2, 9, 1, 1, 24, 26, NULL),
(25, 5, NULL, 'normal', 0, 6, 2, 9, 1, 1, 24, 26, NULL),
(26, 0, NULL, 'noBall', 1, 2, 2, 9, 1, 1, 24, 26, NULL),
(27, 0, NULL, 'normal', 1, 6, 2, 9, 1, 1, 24, 26, NULL),
(28, 1, NULL, 'normal', 1, 0, 2, 9, 1, 1, 26, 24, NULL),
(29, 2, NULL, 'wicket', 1, 0, 2, 10, 1, 1, 26, 24, 5),
(30, 3, NULL, 'normal', 1, 4, 2, 10, 1, 1, 26, 27, NULL),
(31, 4, NULL, 'normal', 1, 0, 2, 10, 1, 1, 26, 27, NULL),
(32, 5, NULL, 'wide', 1, 0, 2, 10, 1, 1, 26, 27, NULL),
(33, 5, NULL, 'normal', 1, 0, 2, 10, 1, 1, 26, 27, NULL),
(34, 0, NULL, 'wicket', 2, 1, 2, 10, 1, 1, 26, 27, 6),
(35, 1, NULL, 'normal', 2, 4, 2, 8, 1, 1, 22, 26, NULL),
(36, 2, NULL, 'normal', 2, 0, 2, 8, 1, 1, 22, 26, NULL),
(37, 3, NULL, 'normal', 2, 0, 2, 8, 1, 1, 22, 26, NULL),
(38, 4, NULL, 'normal', 2, 0, 2, 8, 1, 1, 22, 26, NULL),
(39, 5, NULL, 'normal', 2, 0, 2, 8, 1, 1, 22, 26, NULL),
(40, 0, NULL, 'normal', 3, 1, 2, 8, 1, 1, 22, 26, NULL),
(41, 1, '2023-04-14 18:17:25', 'normal', 0, 2, 4, 39, 3, 2, 2, 1, NULL),
(42, 2, '2023-04-14 18:19:20', 'normal', 0, 4, 4, 39, 3, 2, 2, 1, NULL),
(43, 3, '2023-04-14 18:19:34', 'normal', 0, 1, 4, 39, 3, 2, 2, 1, NULL),
(44, 4, '2023-04-14 18:20:35', 'normal', 0, 4, 4, 39, 3, 2, 1, 2, NULL),
(45, 5, '2023-04-14 18:20:54', 'normal', 0, 2, 4, 39, 3, 2, 1, 2, NULL),
(46, 0, '2023-04-14 18:21:36', 'normal', 1, 1, 4, 39, 3, 2, 1, 2, NULL),
(47, 1, '2023-04-14 18:22:16', 'normal', 1, 6, 4, 40, 3, 2, 1, 2, NULL),
(48, 2, '2023-04-14 18:22:58', 'normal', 1, 2, 4, 40, 3, 2, 1, 2, NULL),
(49, 3, '2023-04-14 18:23:05', 'normal', 1, 6, 4, 40, 3, 2, 1, 2, NULL),
(50, 4, '2023-04-14 18:23:15', 'normal', 1, 2, 4, 40, 3, 2, 1, 2, NULL),
(51, 5, '2023-04-14 18:23:28', 'normal', 1, 4, 4, 40, 3, 2, 1, 2, NULL),
(52, 0, '2023-04-14 18:23:44', 'normal', 2, 1, 4, 40, 3, 2, 1, 2, NULL),
(53, 1, '2023-04-14 18:24:06', 'normal', 2, 3, 4, 38, 3, 2, 1, 2, NULL),
(54, 2, '2023-04-14 18:24:45', 'normal', 2, 4, 4, 38, 3, 2, 2, 1, NULL),
(55, 3, '2023-04-14 18:25:13', 'wide', 2, 0, 4, 38, 3, 2, 2, 1, NULL),
(56, 3, '2023-04-14 18:25:31', 'normal', 2, 2, 4, 38, 3, 2, 2, 1, NULL),
(57, 4, '2023-04-14 18:25:41', 'normal', 2, 6, 4, 38, 3, 2, 2, 1, NULL),
(58, 5, '2023-04-14 18:28:17', 'wicket', 2, 0, 4, 38, 3, 2, 2, 1, 7),
(59, 0, '2023-04-14 18:29:47', 'normal', 3, 0, 4, 38, 3, 2, 2, 3, NULL),
(60, 1, '2023-04-14 18:30:28', 'normal', 0, 0, 3, 9, 4, 2, 32, 31, NULL),
(61, 2, '2023-04-14 18:30:39', 'normal', 0, 2, 3, 9, 4, 2, 32, 31, NULL),
(62, 3, '2023-04-14 18:30:51', 'normal', 0, 1, 3, 9, 4, 2, 32, 31, NULL),
(63, 4, '2023-04-14 18:31:20', 'normal', 0, 2, 3, 9, 4, 2, 31, 32, NULL),
(64, 5, '2023-04-14 18:31:43', 'wide', 0, 0, 3, 9, 4, 2, 31, 32, NULL),
(65, 5, '2023-04-14 18:31:59', 'normal', 0, 2, 3, 9, 4, 2, 31, 32, NULL),
(66, 0, '2023-04-14 18:32:14', 'normal', 1, 1, 3, 9, 4, 2, 31, 32, NULL),
(67, 1, '2023-04-14 18:32:46', 'normal', 1, 6, 3, 10, 4, 2, 31, 32, NULL),
(68, 2, '2023-04-14 18:33:01', 'normal', 1, 3, 3, 10, 4, 2, 31, 32, NULL),
(69, 3, '2023-04-14 18:33:16', 'normal', 1, 2, 3, 10, 4, 2, 32, 31, NULL),
(70, 4, '2023-04-14 18:35:42', 'wicket', 1, 0, 3, 10, 4, 2, 32, 31, 8),
(71, 5, '2023-04-14 18:36:10', 'wicket', 1, 0, 3, 10, 4, 2, 32, 33, 9),
(72, 0, '2023-04-14 18:36:36', 'wicket', 2, 0, 3, 10, 4, 2, 32, 34, 10),
(73, 1, '2023-04-14 18:37:53', 'normal', 2, 2, 3, 8, 4, 2, 34, 32, NULL),
(74, 2, '2023-04-14 18:38:02', 'normal', 2, 2, 3, 8, 4, 2, 34, 32, NULL),
(75, 3, '2023-04-14 18:38:13', 'normal', 2, 3, 3, 8, 4, 2, 34, 32, NULL),
(76, 4, '2023-04-14 18:38:27', 'normal', 2, 2, 3, 8, 4, 2, 32, 34, NULL),
(77, 5, '2023-04-14 18:38:43', 'wide', 2, 0, 3, 8, 4, 2, 32, 34, NULL),
(78, 0, '2023-04-14 18:39:16', 'normal', 3, 0, 3, 8, 4, 2, 32, 34, NULL);

--
-- Dumping data for table `score_details_seq`
--

INSERT INTO `score_details_seq` (`next_val`) VALUES
(1),
(79),
(79);

--
-- Dumping data for table `team`
--

INSERT INTO `team` (`team_id`, `team_name`, `captain_id`, `match_id`, `wicket_keeper_id`) VALUES
(1, 'India', 2, 1, 1),
(2, 'Australia', 22, 1, 23),
(3, 'Sri Lanka', 37, 2, 35),
(4, 'India', 3, 2, 1),
(7, 'RCB', NULL, 4, NULL),
(8, 'LSG', NULL, 4, NULL);

--
-- Dumping data for table `team_seq`
--

INSERT INTO `team_seq` (`next_val`) VALUES
(1),
(1),
(9);

--
-- Dumping data for table `team_squad`
--

INSERT INTO `team_squad` (`player_id`, `team_id`, `is_playing`) VALUES
(1, 1, 1),
(1, 4, 0),
(1, 7, 0),
(2, 1, 1),
(2, 4, 0),
(2, 7, 0),
(3, 1, 1),
(3, 4, 0),
(4, 1, 1),
(4, 4, 0),
(5, 1, 1),
(5, 4, 0),
(6, 1, 1),
(6, 4, 0),
(7, 1, 1),
(7, 4, 0),
(8, 1, 1),
(8, 4, 0),
(9, 1, 1),
(9, 4, 0),
(10, 1, 1),
(10, 4, 0),
(11, 1, 1),
(11, 4, 0),
(12, 1, 0),
(12, 4, 0),
(13, 1, 0),
(13, 4, 0),
(14, 1, 0),
(14, 4, 0),
(15, 1, 0),
(15, 4, 0),
(16, 2, 1),
(17, 2, 0),
(18, 2, 1),
(19, 2, 1),
(20, 2, 1),
(21, 2, 1),
(22, 2, 1),
(23, 2, 1),
(24, 2, 1),
(25, 2, 0),
(26, 2, 1),
(27, 2, 1),
(28, 2, 1),
(29, 2, 0),
(31, 3, 1),
(32, 3, 1),
(33, 3, 1),
(34, 3, 1),
(35, 3, 1),
(36, 3, 1),
(37, 3, 1),
(38, 3, 1),
(39, 3, 1),
(40, 3, 1),
(41, 3, 1),
(42, 3, 0),
(43, 3, 0);

--
-- Dumping data for table `wicket`
--

INSERT INTO `wicket` (`wicket_id`, `wicket_type`, `batsman_id`, `bowler_id`, `match_id`, `taken_by`) VALUES
(1, 'bowled', 7, 18, 1, NULL),
(2, 'cought', 3, 18, 1, 16),
(3, 'caught', 4, 16, 1, 18),
(4, 'stumped', 5, 16, 1, 23),
(5, 'bowled', 24, 10, 1, NULL),
(6, 'runout', 27, 10, 1, 3),
(7, 'bowled', 1, 38, 2, 38),
(8, 'bowled', 31, 10, 2, 10),
(9, 'bowled', 33, 10, 2, 10),
(10, 'bowled', 33, 10, 2, 10);

--
-- Dumping data for table `wicket_seq`
--

INSERT INTO `wicket_seq` (`next_val`) VALUES
(1),
(11),
(11);
SET FOREIGN_KEY_CHECKS=1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
