import { useId } from "react";

type InputProps = React.InputHTMLAttributes<HTMLInputElement> & {
  label?: string;
};

export function Input({ label, id, ...rest }: InputProps) {
  const inputId = id ?? useId();

  return (
    <div style={{ display: "flex", flexDirection: "column", gap: 6 }}>
      {label && <label htmlFor={inputId}>{label}</label>}

      <input id={inputId} {...rest} />
    </div>
  );
}
