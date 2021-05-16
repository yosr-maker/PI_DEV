import { Contribution } from './Contribution';
export class User  {
    id: number;
    cin: string;
    firstName: string;
    lastName : string;
    email:string;
    phoneNumber:string;
    username:string;
    password:string;
    role:string;
    contribution:Contribution[];
}