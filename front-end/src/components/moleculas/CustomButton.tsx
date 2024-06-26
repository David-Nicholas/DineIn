import * as React from 'react';
import Button from '@mui/material/Button';
import Link from 'next/link';

type CustomButtonProps = {
  text: string;
  route: string;
}

const CustomButton = ({ text, route }: CustomButtonProps) => {

  return (
    <Link href={route}>
      <Button variant="contained" disableElevation sx={{ mr: 1, ml:1, mt:1, mb: 1}}>
        {text}
      </Button>
    </Link>
  );
}

export default CustomButton;