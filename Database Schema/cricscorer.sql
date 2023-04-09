-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 09, 2023 at 02:30 PM
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
(1, 20, 'India won by 34 runs', 'Completed', 'bat', 'Ravi Shastri, Davidson', 1, 1, 2, 1, 1),
(2, 10, NULL, '', NULL, NULL, NULL, 3, 4, NULL, NULL);

--
-- Dumping data for table `match_seq`
--

INSERT INTO `match_seq` (`next_val`) VALUES
(3);

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
(29, 'Right Hand', NULL, 'Josh Inglis', 'Australia', 'Batsman');

--
-- Dumping data for table `player_seq`
--

INSERT INTO `player_seq` (`next_val`) VALUES
(30);

--
-- Dumping data for table `score_details`
--

INSERT INTO `score_details` (`ball_id`, `ball_no`, `event`, `overs`, `runs`, `batting_team_id`, `bowler_id`, `bowling_team_id`, `match_id`, `non_striker_id`, `striker_id`, `wicket_id`) VALUES
(1, 1, 'normal', 0, 6, 1, 18, 2, 1, 2, 1, NULL),
(2, 2, 'normal', 0, 2, 1, 18, 2, 1, 2, 1, NULL),
(3, 3, 'normal', 0, 1, 1, 18, 2, 1, 2, 1, NULL),
(4, 4, 'wicket', 0, 1, 1, 18, 2, 1, 1, 2, 1),
(5, 4, 'wide', 0, 1, 1, 18, 2, 1, 1, 3, NULL),
(6, 5, 'wicket', 0, 0, 1, 18, 2, 1, 1, 3, 2),
(7, 6, 'normal', 0, 0, 1, 18, 2, 1, 1, 4, NULL),
(8, 1, 'normal', 1, 2, 1, 16, 2, 1, 4, 1, NULL),
(9, 2, 'normal', 1, 0, 1, 16, 2, 1, 4, 1, NULL),
(10, 3, 'wide', 1, 0, 1, 16, 2, 1, 4, 1, NULL),
(11, 3, 'normal', 1, 1, 1, 16, 2, 1, 4, 1, NULL),
(12, 4, 'normal', 1, 4, 1, 16, 2, 1, 1, 4, NULL),
(13, 5, 'normal', 1, 6, 1, 16, 2, 1, 1, 4, NULL),
(14, 6, 'wicket', 1, 0, 1, 16, 2, 1, 1, 4, 3),
(15, 1, 'normal', 2, 2, 1, 16, 2, 1, 5, 1, NULL),
(16, 2, 'normal', 2, 4, 1, 16, 2, 1, 5, 1, NULL),
(17, 3, 'normal', 2, 1, 1, 16, 2, 1, 5, 1, NULL),
(18, 4, 'normal', 2, 1, 1, 16, 2, 1, 1, 5, NULL),
(19, 5, 'normal', 2, 2, 1, 16, 2, 1, 5, 1, NULL),
(20, 6, 'wicket', 2, 0, 1, 16, 2, 1, 1, 5, 4),
(21, 1, 'normal', 0, 2, 2, 9, 1, 1, 26, 24, NULL),
(22, 2, 'normal', 0, 0, 2, 9, 1, 1, 26, 24, NULL),
(23, 3, 'normal', 0, 1, 2, 9, 1, 1, 26, 24, NULL),
(24, 4, 'normal', 0, 4, 2, 9, 1, 1, 24, 26, NULL),
(25, 5, 'normal', 0, 6, 2, 9, 1, 1, 24, 26, NULL),
(26, 6, 'noBall', 0, 2, 2, 9, 1, 1, 24, 26, NULL),
(27, 6, 'normal', 0, 6, 2, 9, 1, 1, 24, 26, NULL),
(28, 1, 'normal', 1, 0, 2, 9, 1, 1, 26, 24, NULL),
(29, 2, 'wicket', 1, 0, 2, 10, 1, 1, 26, 24, 5),
(30, 3, 'normal', 1, 4, 2, 10, 1, 1, 26, 27, NULL),
(31, 4, 'normal', 1, 0, 2, 10, 1, 1, 26, 27, NULL),
(32, 5, 'wide', 1, 0, 2, 10, 1, 1, 26, 27, NULL),
(33, 5, 'normal', 1, 0, 2, 10, 1, 1, 26, 27, NULL),
(34, 6, 'normal', 1, 1, 2, 10, 1, 1, 26, 27, 6),
(35, 1, 'normal', 2, 4, 2, 8, 1, 1, 22, 26, NULL),
(36, 2, 'normal', 2, 0, 2, 8, 1, 1, 22, 26, NULL),
(37, 3, 'normal', 2, 0, 2, 8, 1, 1, 22, 26, NULL),
(38, 4, 'normal', 2, 0, 2, 8, 1, 1, 22, 26, NULL),
(39, 5, 'normal', 2, 0, 2, 8, 1, 1, 22, 26, NULL),
(40, 6, 'normal', 2, 1, 2, 8, 1, 1, 22, 26, NULL);

--
-- Dumping data for table `score_details_seq`
--

INSERT INTO `score_details_seq` (`next_val`) VALUES
(41);

--
-- Dumping data for table `team`
--

INSERT INTO `team` (`team_id`, `team_name`, `captain_id`, `match_id`, `wicket_keeper_id`) VALUES
(1, 'India', 2, 1, 1),
(2, 'Australia', 22, 1, 23),
(3, 'Sri Lanka', NULL, NULL, NULL),
(4, 'India', NULL, NULL, NULL);

--
-- Dumping data for table `team_seq`
--

INSERT INTO `team_seq` (`next_val`) VALUES
(5);

--
-- Dumping data for table `team_squad`
--

INSERT INTO `team_squad` (`player_id`, `team_id`, `is_playing`) VALUES
(1, 1, 1),
(1, 4, 0),
(2, 1, 1),
(2, 4, 0),
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
(29, 2, 0);

--
-- Dumping data for table `wicket`
--

INSERT INTO `wicket` (`wicket_id`, `wicket_type`, `batsman_id`, `bowler_id`, `match_id`, `taken_by`) VALUES
(1, 'bowled', 2, 18, 1, NULL),
(2, 'cought', 3, 18, 1, 16),
(3, 'caught', 4, 16, 1, 18),
(4, 'stumped', 5, 16, 1, 23),
(5, 'bowled', 24, 10, 1, NULL),
(6, 'runout', 27, 10, 1, 3);

--
-- Dumping data for table `wicket_seq`
--

INSERT INTO `wicket_seq` (`next_val`) VALUES
(7);
SET FOREIGN_KEY_CHECKS=1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
