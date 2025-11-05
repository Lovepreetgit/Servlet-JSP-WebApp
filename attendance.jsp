<!-- attendance.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Student Attendance</title>
</head>
<body>
  <h2>Attendance Form</h2>
  <form method="POST" action="AttendanceServlet">
    <label>Student ID:</label>
    <input type="text" name="studentID" required>
    <br>
    <label>Date:</label>
    <input type="date" name="date" required>
    <br>
    <label>Status:</label>
    <select name="status">
      <option value="Present">Present</option>
      <option value="Absent">Absent</option>
    </select>
    <br>
    <button type="submit">Submit</button>
  </form>
</body>
</html>
