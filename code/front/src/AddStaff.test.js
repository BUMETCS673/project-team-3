import { fireEvent, render, screen } from '@testing-library/react';
import App from './App';

test('renders Add Staff page', () => {
  render(<App />);
  const linkElement = screen.getByText(/Add Staff/i);
  fireEvent.click(linkElement);

  const register = screen.getByText(/Register Staff/i);
  expect(register).toBeInTheDocument();

  const name = screen.getByText(/Name/i);
  expect(name).toBeInTheDocument();

  const job = screen.getByText(/Job Title/i);
  expect(job).toBeInTheDocument();

  const salary = screen.getByText(/Annual Salary/i);
  expect(salary).toBeInTheDocument();

  const submit = screen.getByText(/Submit/i);
  expect(submit).toBeInTheDocument();
  
  const cancel = screen.getByText(/Cancel/i);
  expect(cancel).toBeInTheDocument();
});