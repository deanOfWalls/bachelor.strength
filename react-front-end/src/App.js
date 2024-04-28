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
            placeholder="Height"
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
            placeholder="Weight"
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
            placeholder="Gender"
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
    </div>
  );
}

export default App;
