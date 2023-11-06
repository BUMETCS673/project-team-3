import { render, screen } from '@testing-library/react';
import React from 'react';
import ViewStaff from './Users/ViewStaff';
import { MemoryRouter } from 'react-router-dom';
import axios from 'axios';


jest.mock('axios', () => {
  return {
    create: jest.fn(() => ({
      get: jest.fn(),
      interceptors: {
        request: { use: jest.fn(), eject: jest.fn() },
        response: { use: jest.fn(), eject: jest.fn() }
      }
    }))
  }
})

  test('renders View Staff page', async () => {
    const fakeUser = { name:"Alice",
        jobTitle: "QA",
        annualSalary:"100000"};

    const payload = { data: fakeUser };    

    axios.get = jest.fn().mockResolvedValue(payload); 


    render(<MemoryRouter><ViewStaff /></MemoryRouter>);

    
    const staffDetails = screen.getByText(/Staff Details/i);
    expect(staffDetails).toBeInTheDocument();

    const details = screen.getByText(/Detail of user id:/i);
    expect(details).toBeInTheDocument();

    const name = screen.getByText(/Name/i);
    expect(name).toBeInTheDocument();

    const jobTitle = screen.getByText(/Job Title/i);
    expect(jobTitle).toBeInTheDocument();

    const annualSalary = screen.getByText(/Annual Salary/i);
    expect(annualSalary).toBeInTheDocument();
  });

  