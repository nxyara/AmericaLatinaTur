import styles from './card.module.css';

const card = {
	id: 1,
	title: 'Card',
	description: 'Primeiro card.',
	viagemURL: "https://lh3.googleusercontent.com/p/AF1QipO2NIzSUwUjtU7MAWsML_F6ft7UfPAX1sttz_C2=s680-w680-h510"
},
{
	title: 'Card2.',
	description: 'Segundo card.',
	viagemURL: "https://encrypted-tbn1.gstatic.com/licensed-image?q=tbn:ANd9GcTw6KTTQf36P9IjnV2Ore8beWC7AN9ZjZPlw15UV0LRVBVt9IRGySmSqJ5pwaJn7-Wm78NhefuTF0hIxz-b7obVxOLy_QafdzH8Xs9d3Q"
},
{
	title: 'Card3',
	description: 'Terceiro card.',
	viagemURL: "https://lh3.googleusercontent.com/p/AF1QipNL8lmndfwsn2cha4t9K0FUPmfFqUooqWpsXXHd=s680-w680-h510"
};

export default async function Card() {
	const cards = await fetch('http://localhost:5119/5entrega/viagens').then(res => res.json());
	console.log(cards);        

	return (
		<div className={styles.container}>
			{{cards?.map((card) => (
				<div key={card.id} className={styles.card}>
					<img src={card.viagemURL} alt={card.title} />
					
					<div className={styles.card_title}>
						<p>{card.name}</p>
					</div>
				</div>
			))}}
		</div>
	);
}