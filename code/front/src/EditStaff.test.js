import { render, screen } from '@testing-library/react';
import React from 'react';
import EditStaff from './Users/EditStaff';
import { MemoryRouter } from 'react-router-dom';
import axios from 'axios';


  test('renders Edit Staff page', async () => {
    const fakeUser = { name:"Alice",
        jobTitle: "QA",
        annualSalary:"100000"};

    const payload = { data: fakeUser };    

    axios.get = jest.fn().mockResolvedValue(payload); 


    render(<MemoryRouter><EditStaff /></MemoryRouter>);

    
    const editStaff = screen.getByText(/Edit Staff/i);
    expect(editStaff).toBeInTheDocument();

    const name = screen.getByText(/Name/i);
    expect(name).toBeInTheDocument();

    const jobTitle = screen.getByText(/Job Title/i);
    expect(jobTitle).toBeInTheDocument();

    const annualSalary = screen.getByText(/Annual Salary/i);
    expect(annualSalary).toBeInTheDocument();

    const submit = screen.getByText(/Submit/i);
    expect(submit).toBeInTheDocument();

    const cancel = screen.getByText(/Cancel/i);
    expect(cancel).toBeInTheDocument();
  });

  