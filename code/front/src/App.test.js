import { render, screen } from '@testing-library/react';
import App from './App';

test('renders Add Staff button link', () => {
  render(<App />);
  const linkElement = screen.getByText(/Add Staff/i);
  expect(linkElement).toBeInTheDocument();
});


