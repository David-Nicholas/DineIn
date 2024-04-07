import * as React from 'react';
import Button from '@mui/material/Button';

type CustomButtonProps = {
  text: string;
}

const CustomButton = ({ text }: CustomButtonProps) => {
  return (
    <Button variant="contained" disableElevation>
      {text}
    </Button>
  );
}

export default CustomButton;