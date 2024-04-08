import * as React from 'react';
import Button from '@mui/material/Button';
import { useRouter } from 'next/navigation'

type CustomButtonProps = {
  text: string;
  route: string;
}

const CustomButton = ({ text, route }: CustomButtonProps) => {

  const router = useRouter()

  return (
    <Button onClick={()=>router.push(route)} variant="contained" disableElevation>
      {text}
    </Button>
  );
}

export default CustomButton;
