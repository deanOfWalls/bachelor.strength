import React, { useState } from 'react';
import './App.css';

function App() {
  const [formData, setFormData] = useState({
    age: '',
    height: '',
    weight: '',
    gender: '',
    bmi: '',
    tdee: '',
    recommendedProtein: '',
    recommendedCalories: ''
  });

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const response = await fetch('http://localhost:8080/calculate', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(formData)
      });

      if (!response.ok) {
        throw new Error('Network response was not ok');
      }

      const data = await response.json();
      setFormData({
        ...formData,
        bmi: data.bmi,
        tdee: data.tdee,
        recommendedProtein: data.recommendedProtein,
        recommendedCalories: data.recommendedCalories
      });
    } catch (error) {
      console.error('Error:', error);
    }
  };

  return (
    <div className="container">
      <div className="box">
        <div className="form-group">
          <input
            type="number"
            name="age"
            value={formData.age}
            onChange={handleChange}
            placeholder="Age"
            className="input-field"
            maxLength="6"
          />
        </div>
        <div className="form-group">
          <input
            type="number"
            name="height"
            value={formData.height}
            onChange={handleChange}
            placeholder="Height (cm)"
            className="input-field"
            maxLength="6"
          />
        </div>
        <div className="form-group">
          <input
            type="number"
            name="weight"
            value={formData.weight}
            onChange={handleChange}
            placeholder="Weight (lbs)"
            className="input-field"
            maxLength="6"
          />
        </div>
        <div className="form-group">
          <input
            type="text"
            name="gender"
            value={formData.gender}
            onChange={handleChange}
            placeholder="Gender (Male/Female)"
            className="input-field"
            maxLength="6"
          />
        </div>
        <div className="form-group">
          <button type="submit" className="btn" onClick={handleSubmit}>
            Calculate
          </button>
        </div>
        <div className="placeholders">
          <p>BMI: {formData.bmi}</p>
          <p>TDEE: {formData.tdee}</p>
          <p>Recommended Protein: {formData.recommendedProtein}</p>
          <p>Recommended Calories: {formData.recommendedCalories}</p>
        </div>
      </div>

      <div className="box">
        <h2>Weekly Hypertrophy-Focused Routine:</h2>
        <h3>Monday & Thursday (Lower Body + Calves)</h3>
        <ul>
          <li>Barbell Squats: 4 sets of 8 reps</li>
          <li>Deadlifts: 3 sets of 6-8 reps (alternate between standard and Romanian deadlifts for variety and balanced development)</li>
          <li>Calf Raises: 4 sets of 15 reps with added weight (if possible)</li>
        </ul>
        <h3>Tuesday & Friday (Upper Body - Push)</h3>
        <ul>
          <li>Bench Press: 4 sets of 8 reps</li>
          <li>Seated Dumbbell Shoulder Press: 4 sets of 8 reps</li>
          <li>Tricep Dips: Start with Bench Dips or Negative Dips and progress to 3 sets of 8-10 reps as strength improves</li>
        </ul>
        <h3>Wednesday & Saturday (Upper Body - Pull + Core)</h3>
        <ul>
          <li>Barbell Rows (using EZ curl bar): 4 sets of 8 reps</li>
          <li>Pull-Ups/Chin-Ups: 3 sets to failure</li>
          <li>Dumbbell Curls: 3 sets of 10-12 reps</li>
          <li>Hammer Curls: 3 sets of 10-12 reps</li>
          <li>Leg Raises: 4 sets of 12 reps</li>
        </ul>
        <p>Rest Day: Sunday</p>
      </div>
    </div>
  );
}

export default App;
