import { fireEvent, render, screen } from '@testing-library/react';
import HomePage_Manager from './HomePage_Manager';

test('renders Add Staff page', () => {
    render(<HomePage_Manager />);
    const linkElement = screen.getByText(/#/i);
    fireEvent.click(linkElement);
  
    const register = screen.getByText(/ID/i);
    expect(register).toBeInTheDocument();
  
    const name = screen.getByText(/Name/i);
    expect(name).toBeInTheDocument();
  
    const job = screen.getByText(/Job Title/i);
    expect(job).toBeInTheDocument();
  
    const salary = screen.getByText(/Annual Salary/i);
    expect(salary).toBeInTheDocument();

  });