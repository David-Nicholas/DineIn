import * as React from 'react';
import Button from '@mui/material/Button';

interface CustomButtonProps {
  text: string;
}

const CustomButton: React.FC<CustomButtonProps> = ({ text }) => {
  return (
    <Button variant="contained" disableElevation>
      {text}
    </Button>
  );
}

export default CustomButton;